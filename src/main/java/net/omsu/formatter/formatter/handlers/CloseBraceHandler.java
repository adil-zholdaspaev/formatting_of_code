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
        int nestingLevel = context.getNestingLevel() - 1;

        context.setNestingLevel(nestingLevel);

        final StringBuilder result = new StringBuilder();
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel; i++) {
            result.append(permanentContext.getTab());
        }
        result.append(permanentContext.getCloseBrace());
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel; i++) {
            result.append(permanentContext.getTab());
        }

        context.setFormattedString(result.toString());
    }
}
