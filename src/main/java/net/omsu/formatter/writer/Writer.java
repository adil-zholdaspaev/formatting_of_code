package net.omsu.formatter.writer;

/**
 * Interface for writing data.
 */
public interface Writer {

    public void write(final String data);
    public void close();
}
