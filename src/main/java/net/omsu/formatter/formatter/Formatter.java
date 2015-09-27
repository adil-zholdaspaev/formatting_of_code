package net.omsu.formatter.formatter;

import net.omsu.formatter.exception.ReaderException;
import net.omsu.formatter.exception.WriterException;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 * Interface for formatting some kind of data.
 */
public interface Formatter {

    void format(final Reader reader, final Writer writer) throws ReaderException, WriterException;
}
