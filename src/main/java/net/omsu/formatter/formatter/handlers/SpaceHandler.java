package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class SpaceHandler implements Handler {

    private final JavaPermanentContext permanentContext;

    public SpaceHandler(final JavaPermanentContext permanentContext) {
        this.permanentContext = permanentContext;
    }

    @Override
    public void handle(Context context) {
        String lastCharacter = context.getLastCharacters();

        if (lastCharacter.equals(permanentContext.getSpace())) {
            context.setFormattedString("");
            return;
        }

        context.setFormattedString(permanentContext.getSpace());
    }
}
