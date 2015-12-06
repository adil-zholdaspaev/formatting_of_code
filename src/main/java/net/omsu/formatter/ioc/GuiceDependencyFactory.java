package net.omsu.formatter.ioc;

import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.formatter.context.JavaPermanentContext;
import net.omsu.formatter.formatter.context.factory.ContextFactory;
import net.omsu.formatter.formatter.context.factory.JavaContextFactory;
import net.omsu.formatter.formatter.handlers.*;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class GuiceDependencyFactory implements DependencyFactory {

    public GuiceDependencyFactory() {
    }

    @Override
    public Reader buildReader() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class readerClass = Class.forName("net.omsu.formatter.reader.FileReader");
        Constructor constructor = readerClass.getConstructor(String.class);
        Reader reader = (Reader) constructor.newInstance("format.java");

        return reader;
    }

    @Override
    public Writer buildWriter() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Class readerClass = Class.forName("net.omsu.formatter.writer.FileWriter");
        Constructor constructor = readerClass.getConstructor(String.class);
        Writer writer = (Writer) constructor.newInstance("output.java");

        return writer;
    }

    @Override
    public Formatter buildFormatter() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        JavaPermanentContext permanentContext = JavaPermanentContext.newBuilder().build();

        List<Handler> handlers = new LinkedList<>();
        handlers.add(new OpenBraceHandler(permanentContext));
        handlers.add(new CloseBraceHandler(permanentContext));
        handlers.add(new SemicolonHandler(permanentContext));
        handlers.add(new SpaceHandler(permanentContext));
        handlers.add(new CharHandler(permanentContext));

        ContextFactory javaContextFactory = new JavaContextFactory();


        Class readerClass = Class.forName("net.omsu.formatter.formatter.JavaCodeFormatter");
        Constructor constructor = readerClass.getConstructor(List.class, ContextFactory.class);
        Formatter formatter = (Formatter) constructor.newInstance(handlers, javaContextFactory);

        return formatter;
    }
}
