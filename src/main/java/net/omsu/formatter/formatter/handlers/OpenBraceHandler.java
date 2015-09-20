package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class OpenBraceHandler implements Handler {

    public OpenBraceHandler() {
    }

    @Override
    public String handle(final Character character, final int nestingLevel) {
        return "{";
    }
}
