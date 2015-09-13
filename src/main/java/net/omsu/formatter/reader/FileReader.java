package net.omsu.formatter.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 */
public class FileReader implements Reader {

    private final BufferedReader bufferedReader;
    private boolean isStreamClosed = false;

    public FileReader(final String fileName) throws FileNotFoundException {

        bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
    }

    @Override
    public String readLine() throws IOException {

        if (isStreamClosed) {
            return null;
        }

        return bufferedReader.readLine();
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
        isStreamClosed = true;
    }
}
