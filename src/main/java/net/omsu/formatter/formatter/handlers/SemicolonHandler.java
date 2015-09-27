package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.ContextKeys;

import java.util.Optional;

/**
 *
 */
public class SemicolonHandler implements Handler {

    public SemicolonHandler() {
    }

    @Override
    public void handle(Context context) {
        Optional<Character> lastChar = context.get(ContextKeys.LAST_CHARACTER, Character.class);
        Optional<Character> currentChar = context.get(ContextKeys.CURRENT_CHARACTER, Character.class);
        Optional<Integer> nestingLevel = context.get(ContextKeys.NESTING_LEVEL, Integer.class);

        if (!currentChar.get().equals(';')) {
            return;
        }

        final StringBuilder result = new StringBuilder();
        result.append(';');
        result.append('\n');
        for (int i = 0; i < nestingLevel.get(); i++) {
            result.append("    ");
        }

        context.set(ContextKeys.RESULT, result.toString());
    }
}
