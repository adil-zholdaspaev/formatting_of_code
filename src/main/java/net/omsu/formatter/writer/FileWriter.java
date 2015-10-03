package net.omsu.formatter.writer;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 */
public class FileWriter implements Writer {

    private final BufferedWriter bufferedWriter;
    private boolean isStreamClosed = false;

    public FileWriter(final String fileName) throws WriterException {
        if (fileName == null) {
            throw new WriterException("File name can't be null", new Exception());
        }

        try {
            bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName));
        } catch (IOException ex) {
            throw new WriterException(String.format("File %s can't be created or opened", fileName), ex);
        }
    }

    @Override
    public void write(final String data) throws WriterException {
        if (isStreamClosed) {
            return;
        }

        try {
            bufferedWriter.write(data);
        } catch (IOException ex) {
            throw new WriterException("Can't write data", ex);
        }
    }

    @Override
    public void close() throws WriterException {
        try {
            bufferedWriter.close();
        } catch (IOException ex) {
            throw new WriterException("Can't close file writer", ex);
        }
        isStreamClosed = true;
    }
}
