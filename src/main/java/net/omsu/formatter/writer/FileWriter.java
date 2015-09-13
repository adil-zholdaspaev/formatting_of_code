package net.omsu.formatter.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class FileWriter implements Writer {

    private final BufferedWriter bufferedWriter;
    private boolean isStreamClosed = false;

    public FileWriter(final String fileName) throws IOException {

        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        bufferedWriter = new BufferedWriter(new java.io.FileWriter(file.getAbsolutePath()));
    }

    @Override
    public void writeLine(final String line) throws IOException {
        if (isStreamClosed) {
            return;
        }

        bufferedWriter.write(line);
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
        isStreamClosed = true;
    }
}
