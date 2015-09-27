package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.ContextKeys;

import java.util.Optional;

/**
 *
 */
public class SpaceHandler implements Handler {

    public SpaceHandler() {
    }

    @Override
    public void handle(Context context) {
        Optional<Character> lastChar = context.get(ContextKeys.LAST_CHARACTER, Character.class);
        Optional<Character> currentChar = context.get(ContextKeys.CURRENT_CHARACTER, Character.class);
        Optional<Integer> nestingLevel = context.get(ContextKeys.NESTING_LEVEL, Integer.class);

        if (!currentChar.get().equals(' ')) {
            return;
        }

        if (lastChar.get().equals('{') ||
                lastChar.get().equals('}') ||
                lastChar.get().equals(' ') ||
                lastChar.get().equals(';') ||
                lastChar.get().equals('\n')) {

            context.set(ContextKeys.RESULT, "");
            return;
        }

        context.set(ContextKeys.RESULT, " ");
    }
}
