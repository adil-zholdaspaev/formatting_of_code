package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;

/**
 *
 */
public class OpenBraceHandler implements Handler {

    public OpenBraceHandler() {
    }

    @Override
    public void handle(Context context) {
        Character lastCharacter = context.getLastCharacter();
        Character currentCharacter = context.getCurrentCharacter();
        int nestingLevel = context.getNestingLevel();

        if (!currentCharacter.equals('{')) {
            return;
        }

        context.setNestingLevel(nestingLevel + 1);

        final StringBuilder result = new StringBuilder();
        if (!lastCharacter.equals(' ')) {
            result.append(' ');
        }
        result.append('{');
        result.append('\n');
        for (int i = 0; i < nestingLevel + 1; i++) {
            result.append("    ");
        }

        context.setFormattedString(result.toString());
    }
}
