package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;

/**
 *
 */
public class SpaceHandler implements Handler {

    public SpaceHandler() {
    }

    @Override
    public void handle(Context context) {
        Character lastCharacter = context.getLastCharacter();
        Character currentCharacter = context.getCurrentCharacter();

        if (!currentCharacter.equals(' ')) {
            return;
        }

        if (lastCharacter.equals('{') ||
                lastCharacter.equals('}') ||
                lastCharacter.equals(' ') ||
                lastCharacter.equals(';') ||
                lastCharacter.equals('\n')) {

            return;
        }

        context.setFormattedString(" ");
    }
}
