package net.omsu.formatter.formatter.strategy;

import net.omsu.formatter.reader.Reader;

/**
 *
 */
public class SignReaderStrategy implements ReaderStrategy {

    private final Reader reader;

    SignReaderStrategy(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public String getNext() {

        return String.valueOf(reader.read());
    }
}
