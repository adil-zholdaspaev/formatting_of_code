package net.omsu.formatter.writer;

import net.omsu.formatter.exception.GeneralException;

/**
 * Interface for writing data.
 */
public interface Writer {

    public void write(final String data) throws GeneralException;
    public void close() throws GeneralException;
}
