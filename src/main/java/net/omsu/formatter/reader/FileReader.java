package net.omsu.formatter.reader;

import net.omsu.formatter.exception.GeneralException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class FileReader implements Reader {

    // bufferSize may be configured
    private static final int bufferSize = 10;

    private final BufferedReader bufferedReader;
    private Queue<Character> characterBuffer;
    private boolean isEndOfFile = false;

    public FileReader(final String fileName) throws GeneralException {
        if (fileName == null) {
            throw new GeneralException("File name can't be null", new Exception());
        }

        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException ex) {
            throw new GeneralException(String.format("File with name %s not found", fileName), ex);
        }

        characterBuffer = new LinkedList<>();
        fillBuffer();
    }

    @Override
    public char read() throws GeneralException {
        char currentCharacter = characterBuffer.poll();
        if (!hasNext()) {
            fillBuffer();
        }

        return currentCharacter;
    }

    @Override
    public boolean hasNext() {
        return !characterBuffer.isEmpty();
    }

    @Override
    public void close() throws GeneralException {
        isEndOfFile = true;
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            throw new GeneralException(String.format("Can not close reader"), ex);
        }
    }

    private void fillBuffer() throws GeneralException {
        if (hasNext() || isEndOfFile) {
            return;
        }
        for (int i = 0; i < bufferSize; i++) {
            try {
                int characterCode = bufferedReader.read();
                if (characterCode == -1) {
                    isEndOfFile = true;
                    return;
                }
                characterBuffer.add((char) characterCode);
            } catch (IOException ex) {
                throw new GeneralException(String.format("Can't read character from file"), ex);
            }
        }
    }
}
