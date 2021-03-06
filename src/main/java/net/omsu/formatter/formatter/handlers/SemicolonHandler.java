package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class SemicolonHandler implements Handler {

    private final JavaPermanentContext permanentContext;

    public SemicolonHandler(final JavaPermanentContext permanentContext) {
        this.permanentContext = permanentContext;
    }

    @Override
    public void handle(Context context) {
        int nestingLevel = context.getNestingLevel();

        final StringBuilder result = new StringBuilder();
        result.append(permanentContext.getSemicolon());
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel; i++) {
            result.append(permanentContext.getTab());
        }

        context.setFormattedString(result.toString());
    }
}
