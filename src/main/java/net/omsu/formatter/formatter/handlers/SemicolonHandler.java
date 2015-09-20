package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class SemicolonHandler implements Handler {

    public SemicolonHandler() {
    }

    @Override
    public String handle(Character character, int nestingLevel) {
        return ";";
    }
}
