package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;

import java.util.Optional;

/**
 *
 */
public class SemicolonHandler implements Handler {

    public SemicolonHandler() {
    }

    @Override
    public void handle(Context context) {
        Character currentCharacter = context.getCurrentCharacter();
        int nestingLevel = context.getNestingLevel();

        if (!currentCharacter.equals(';')) {
            return;
        }

        final StringBuilder result = new StringBuilder();
        result.append(';');
        result.append('\n');
        for (int i = 0; i < nestingLevel; i++) {
            result.append("    ");
        }

        context.setFormattedString(result.toString());
    }
}
