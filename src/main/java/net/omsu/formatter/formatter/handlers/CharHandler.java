package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;

/**
 *
 */
public class CharHandler implements Handler {



    public CharHandler() {
    }

    @Override
    public void handle(final Context context) {
        Character currentCharacter = context.getCurrentCharacter();

        if (currentCharacter.equals('{') ||
                currentCharacter.equals('}') ||
                currentCharacter.equals(' ') ||
                currentCharacter.equals(';') ||
                currentCharacter.equals('\n')) {
            return;
        }

        context.setFormattedString(currentCharacter.toString());
    }
}
