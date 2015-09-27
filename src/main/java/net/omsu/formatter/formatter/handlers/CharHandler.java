package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.ContextKeys;

import java.util.Optional;

/**
 *
 */
public class CharHandler implements Handler {



    public CharHandler() {
    }

    @Override
    public void handle(final Context context) {
        Optional<Character> lastChar = context.get(ContextKeys.LAST_CHARACTER, Character.class);
        Optional<Character> currentChar = context.get(ContextKeys.CURRENT_CHARACTER, Character.class);
        Optional<Integer> nestingLevel = context.get(ContextKeys.NESTING_LEVEL, Integer.class);

        if (currentChar.get().equals('{') ||
                currentChar.get().equals('}') ||
                currentChar.get().equals(' ') ||
                currentChar.get().equals(';') ||
                currentChar.get().equals('\n')) {
            return;
        }

        context.set(ContextKeys.RESULT, currentChar.get().toString());
    }
}
