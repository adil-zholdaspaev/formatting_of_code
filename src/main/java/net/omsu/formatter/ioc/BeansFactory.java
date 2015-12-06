package net.omsu.formatter.ioc;

import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

import java.lang.reflect.InvocationTargetException;

/**
 *
 */
public interface BeansFactory {

    Reader buildReader() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
    Writer buildWriter() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException;
    Formatter buildFormatter() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
