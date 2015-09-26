package net.omsu.formatter.reader;

import net.omsu.formatter.exception.ReaderException;

/**
 * Interface for reading data.
 */
public interface Reader {

    public char read() throws ReaderException;
    public boolean hasNext();
    public void close() throws ReaderException;
}
