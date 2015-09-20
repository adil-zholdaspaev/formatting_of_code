package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class SpaceHandler implements Handler {

    public SpaceHandler() {
    }

    @Override
    public String handle(final Character character, final int nestingLevel) {
        return " ";
    }
}
