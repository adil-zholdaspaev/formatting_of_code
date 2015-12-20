package net.omsu.formatter.ioc;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.formatter.context.JavaPermanentContext;
import net.omsu.formatter.formatter.context.factory.ContextFactory;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JavaBeansFactory implements BeansFactory {

    private static final Logger log = LoggerFactory.getLogger(JavaBeansFactory.class);

    private final Config config;

    public JavaBeansFactory() {
        config = ConfigFactory.load();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Reader buildReader() throws BeansFactoryException {
        try {
            Class readerClass = Class.forName(config.getString("reader.class"));
            Constructor constructor = readerClass.getConstructor(String.class);
            return (Reader) constructor.newInstance(config.getString("reader.param.file"));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException e) {

            log.error("Encountered exception on constructing Reader bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Reader bean", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Writer buildWriter() throws BeansFactoryException {
        try {
            Class readerClass = Class.forName(config.getString("writer.class"));
            Constructor constructor = readerClass.getConstructor(String.class);
            return (Writer) constructor.newInstance(config.getString("writer.param.file"));
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                ClassNotFoundException e) {

            log.error("Encountered exception on constructing Writer bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Writer bean", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Formatter buildFormatter() throws BeansFactoryException {
        try {
            Class readerClass = Class.forName(config.getString("formatter.class"));
            Constructor constructor = readerClass.getConstructor(List.class, ContextFactory.class);
            return (Formatter) constructor.newInstance(buildHandlers(), buildContextFactory());
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                ClassNotFoundException e) {

            log.error("Encountered exception on constructing Formatter bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Formatter bean", e);
        }
    }

    @SuppressWarnings("unchecked")
    private List<Handler> buildHandlers() {
        List<Handler> handlers = new ArrayList<>();

        List<Config> configs = (List<Config>) config.getConfigList("handlers");
        for (Config handlerConfig : configs) {
            handlers.add(buildHandler(handlerConfig.getString("class")));
        }
        return handlers;
    }

    @SuppressWarnings("unchecked")
    private Handler buildHandler(final String className) {
        try {
            Class handlerClass = Class.forName(className);
            Constructor constructor = handlerClass.getConstructor(JavaPermanentContext.class);
            return (Handler) constructor.newInstance(buildPermanentContext());
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException |
                IllegalAccessException e) {

            log.error("Encountered exception on constructing Context bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Context bean", e);
        }
    }

    @SuppressWarnings("unchecked")
    private JavaPermanentContext buildPermanentContext() {
        JavaPermanentContext.Builder builder;
        try {
            Class contextClass = Class.forName(config.getString("context.class"));
            Method method = contextClass.getMethod("newBuilder");
            builder = (JavaPermanentContext.Builder) method.invoke(JavaPermanentContext.Builder.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            log.error("Encountered exception on constructing Permanent Context bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Permanent Context bean", e);
        }

        builder.setOpenBrace(config.getString("context.params.open-brace").charAt(0));
        builder.setCloseBrace(config.getString("context.params.close-brace").charAt(0));
        builder.setNewLine(config.getString("context.params.line-separator").charAt(0));
        builder.setOpenBracket(config.getString("context.params.open-bracket").charAt(0));
        builder.setCloseBracket(config.getString("context.params.open-bracket").charAt(0));
        builder.setSemicolon(config.getString("context.params.semicolon").charAt(0));
        builder.setSpace(config.getString("context.params.space").charAt(0));
        builder.setTab(config.getString("context.params.tab"));

        return builder.build();
    }

    @SuppressWarnings("unchecked")
    private ContextFactory buildContextFactory() {
        try {
            Class contextFactoryClass = Class.forName(config.getString("context-factory.class"));
            return (ContextFactory) contextFactoryClass.newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            log.error("Encountered exception on constructing Context Factory bean", e);
            throw new BeansFactoryException("Encountered exception on constructing Context Factory bean", e);
        }
    }
}
