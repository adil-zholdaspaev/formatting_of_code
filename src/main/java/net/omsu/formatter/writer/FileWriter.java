package net.omsu.formatter.writer;

import net.omsu.formatter.exception.GeneralException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 */
public class FileWriter implements Writer {

    private final BufferedWriter bufferedWriter;
    private boolean isStreamClosed = false;

    public FileWriter(final String fileName) throws GeneralException {
        if (fileName == null) {
            throw new GeneralException("File name can't be null", new Exception());
        }

        try {
            bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName));
        } catch (IOException ex) {
            throw new GeneralException(String.format("Can't create writer {}", fileName), ex);
        }
    }

    @Override
    public void write(final String data) throws GeneralException {
        if (isStreamClosed) {
            return;
        }

        try {
            bufferedWriter.write(data);
        } catch (IOException ex) {
            throw new GeneralException("Can't write data", ex);
        }
    }

    @Override
    public void close() throws GeneralException {
        try {
            bufferedWriter.close();
        } catch (IOException ex) {
            throw new GeneralException(String.format("Can not close reader"), ex);
        }
        isStreamClosed = true;
    }
}
