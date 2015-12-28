package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class OpenBraceHandler implements Handler {

    private final JavaPermanentContext permanentContext;

    public OpenBraceHandler(final JavaPermanentContext permanentContext) {
        this.permanentContext = permanentContext;
    }

    @Override
    public void handle(Context context) {
        String lastCharacter = context.getLastCharacters();
        int nestingLevel = context.getNestingLevel();

        context.setNestingLevel(nestingLevel + 1);

        final StringBuilder result = new StringBuilder();
        if (!lastCharacter.equals(permanentContext.getSpace()) && !lastCharacter.equals(permanentContext.getOpenBrace())) {
            result.append(permanentContext.getSpace());
        }
        result.append(permanentContext.getOpenBrace());
        result.append(permanentContext.getNewLine());
        for (int i = 0; i < nestingLevel + 1; i++) {
            result.append(permanentContext.getTab());
        }

        context.setFormattedString(result.toString());
    }
}
