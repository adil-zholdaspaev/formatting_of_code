package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class CharHandler implements Handler {

    public CharHandler(final JavaPermanentContext javaPermanentContext) {
    }

    @Override
    public void handle(final Context context) {
        String currentCharacters = context.getCurrentCharacters();
        context.setFormattedString(currentCharacters);
    }
}
