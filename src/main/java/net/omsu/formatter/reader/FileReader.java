package net.omsu.formatter.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 */
public class FileReader implements Reader {

    private static final Logger log = LoggerFactory.getLogger(FileReader.class);

    private final BufferedReader bufferedReader;
    private Character currentCharacter;
    private Character nextCharacter;
    private boolean isReaderClosed = false;

    public FileReader(final String fileName) throws ReaderException {
        if (fileName == null) {
            throw new ReaderException("File name can't be null");
        }

        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException ex) {
            log.error("File {} can't be opened", fileName, ex);
            throw new ReaderException(String.format("File %s can't be opened", fileName), ex);
        }

        currentCharacter = readNext();
        nextCharacter = readNext();
    }

    @Override
    public char read() throws ReaderException {
        if (isReaderClosed || !hasNext()) {
            return (char) -1;
        }
        char result = currentCharacter;
        currentCharacter = nextCharacter;
        nextCharacter = readNext();

        return result;
    }

    @Override
    public boolean hasNext() {
        return currentCharacter != null;
    }

    @Override
    public void close() throws ReaderException {
        isReaderClosed = true;
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            log.error("Can't close the file reader", ex);
            throw new ReaderException("Can't close the file reader", ex);
        }
    }

    private Character readNext() throws ReaderException {
        try {
            int characterCode = bufferedReader.read();
            if (characterCode == -1) {
                return null;
            }
            return (char) characterCode;
        } catch (IOException ex) {
            log.error("Can't read character from file", ex);
            throw new ReaderException("Can't read character from file", ex);
        }
    }
}
