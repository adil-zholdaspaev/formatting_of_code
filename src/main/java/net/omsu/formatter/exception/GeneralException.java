package net.omsu.formatter.exception;

/**
 *
 */
public class GeneralException extends Exception {

    private final Exception exception;

    public GeneralException(final String message) {
        super(message);
        exception = new Exception();
    }

    public GeneralException(final String message, final Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
