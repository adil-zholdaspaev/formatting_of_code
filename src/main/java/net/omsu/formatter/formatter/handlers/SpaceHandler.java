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
    public boolean handle(Context context) {
        Character lastCharacter = context.getLastCharacter();
        Character currentCharacter = context.getCurrentCharacter();

        if (!currentCharacter.equals(permanentContext.getSpace())) {
            return false;
        }

        if (lastCharacter.equals(permanentContext.getOpenBrace()) ||
                lastCharacter.equals(permanentContext.getCloseBrace()) ||
                lastCharacter.equals(permanentContext.getSpace()) ||
                lastCharacter.equals(permanentContext.getSemicolon()) ||
                lastCharacter.equals(permanentContext.getNewLine())) {

            return false;
        }

        context.setFormattedString(String.valueOf(permanentContext.getSpace()));
        return true;
    }
}
