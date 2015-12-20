package net.omsu.formatter.ioc;

import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 *
 */
public interface BeansFactory {

    Reader buildReader() throws BeansFactoryException;
    Writer buildWriter() throws BeansFactoryException;
    Formatter buildFormatter() throws BeansFactoryException;
}
