package net.omsu.formatter.reader;

import net.omsu.formatter.exception.GeneralException;

/**
 * Interface for reading data.
 */
public interface Reader {

    public char read() throws GeneralException;
    public boolean hasNext();
    public void close() throws GeneralException;
}
