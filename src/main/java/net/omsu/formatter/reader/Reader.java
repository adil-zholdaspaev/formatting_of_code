package net.omsu.formatter.reader;

import java.io.IOException;

/**
 *
 */
public interface Reader {

    public String readLine() throws IOException;
    public void close() throws IOException;
}
