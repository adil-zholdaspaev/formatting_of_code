package net.omsu.formatter.ioc;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.formatter.context.JavaPermanentContext;
import net.omsu.formatter.formatter.context.factory.ContextFactory;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JavaBeansFactory implements BeansFactory {

    private final Config config;

    public JavaBeansFactory() {
        config = ConfigFactory.load();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Reader buildReader() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class readerClass = Class.forName(config.getString("reader.class"));
        Constructor constructor = readerClass.getConstructor(String.class);
        return (Reader) constructor.newInstance(config.getString("reader.param.file"));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Writer buildWriter() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Class readerClass = Class.forName(config.getString("writer.class"));
        Constructor constructor = readerClass.getConstructor(String.class);
        return (Writer) constructor.newInstance(config.getString("writer.param.file"));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Formatter buildFormatter() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class readerClass = Class.forName(config.getString("formatter.class"));
        Constructor constructor = readerClass.getConstructor(List.class, ContextFactory.class);
        return (Formatter) constructor.newInstance(buildHandlers(), buildContextFactory());
    }

    @SuppressWarnings("unchecked")
    private List<Handler> buildHandlers() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Handler> handlers = new ArrayList<>();

        List<Config> configs = (List<Config>) config.getConfigList("handlers");
        for (Config handlerConfig : configs) {
            handlers.add(buildHandler(handlerConfig.getString("class")));
        }
        return handlers;
    }

    @SuppressWarnings("unchecked")
    private Handler buildHandler(final String className) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class handlerClass = Class.forName(className);
        Constructor constructor = handlerClass.getConstructor(JavaPermanentContext.class);
        return (Handler) constructor.newInstance(buildPermanentContext());
    }

    @SuppressWarnings("unchecked")
    private JavaPermanentContext buildPermanentContext() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class contextClass = Class.forName(config.getString("context.class"));
        Method method = contextClass.getMethod("newBuilder");
        JavaPermanentContext.Builder builder = (JavaPermanentContext.Builder) method.invoke(JavaPermanentContext.Builder.class);

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
    private ContextFactory buildContextFactory() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class contextFactoryClass = Class.forName(config.getString("context-factory.class"));
        return  (ContextFactory) contextFactoryClass.newInstance();
    }
}
