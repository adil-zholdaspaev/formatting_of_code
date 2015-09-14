package net.omsu.formatter.reader;

/**
 * Interface for reading data.
 */
public interface Reader {

    public char read();
    public boolean hasNext();
    public void close();
}
