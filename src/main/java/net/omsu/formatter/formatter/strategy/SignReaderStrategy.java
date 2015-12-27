package net.omsu.formatter.formatter.strategy;

import net.omsu.formatter.reader.Reader;

/**
 *
 */
public class SignReaderStrategy implements ReaderStrategy {

    private final Reader reader;

    public SignReaderStrategy(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public String getNext() {

        return reader.hasNext() ? String.valueOf(reader.read()) : null;
    }

    public void close() {
        reader.close();
    }
}
