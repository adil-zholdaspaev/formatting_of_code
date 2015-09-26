package net.omsu.formatter.exception;

/**
 *
 */
public class ReaderException extends Exception {

    private final Exception exception;

    public ReaderException(final String message) {
        super(message);
        exception = new Exception();
    }

    public ReaderException(final String message, final Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
