package net.omsu.formatter.writer;

/**
 * Interface for writing data.
 */
public interface Writer {

    public void write(final String data) throws WriterException;
    public void close() throws WriterException;
}
