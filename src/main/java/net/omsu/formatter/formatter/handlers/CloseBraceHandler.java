package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class CloseBraceHandler implements Handler {

    public CloseBraceHandler() {
    }

    @Override
    public String handle(final Character character, final int nestingLevel) {
        return "}";
    }
}
