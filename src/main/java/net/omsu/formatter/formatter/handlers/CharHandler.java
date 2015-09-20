package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class CharHandler implements Handler {

    public CharHandler() {
    }

    @Override
    public String handle(final Character character, final int nestingLevel) {
        return character.toString();
    }
}
