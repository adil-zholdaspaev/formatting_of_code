package net.omsu.formatter.writer;

import java.io.IOException;

/**
 *
 */
public interface Writer {

    public void writeLine(final String line) throws IOException;
    public void close() throws IOException;
}
