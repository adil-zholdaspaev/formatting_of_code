package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class CloseBraceHandler implements Handler {

    private final JavaPermanentContext permanentContext;

    public CloseBraceHandler(final JavaPermanentContext permanentContext) {
        this.permanentContext = permanentContext;
    }

    @Override
    public void handle(Context context) {
        Character currentCharacter = context.getCurrentCharacter();
        int nestingLevel = context.getNestingLevel();

        if (!currentCharacter.equals(permanentContext.getCloseBrace())) {
            return;
        }

        context.setNestingLevel(nestingLevel - 1);

        final StringBuilder result = new StringBuilder();
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel - 1; i++) {
            result.append("    ");
        }
        result.append(permanentContext.getCloseBrace());
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel - 1; i++) {
            result.append(permanentContext.getTab());
        }

        context.setFormattedString(result.toString());
    }
}
