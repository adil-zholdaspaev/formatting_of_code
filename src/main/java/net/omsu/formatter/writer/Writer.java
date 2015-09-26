package net.omsu.formatter.writer;

import net.omsu.formatter.exception.WriterException;

/**
 * Interface for writing data.
 */
public interface Writer {

    public void write(final String data) throws WriterException;
    public void close() throws WriterException;
}
