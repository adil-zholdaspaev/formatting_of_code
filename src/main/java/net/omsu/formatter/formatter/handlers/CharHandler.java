package net.omsu.formatter.formatter.handlers;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaPermanentContext;

/**
 *
 */
public class CharHandler implements Handler {

    private final JavaPermanentContext permanentContext;

    public CharHandler(final JavaPermanentContext permanentContext) {
        this.permanentContext = permanentContext;
    }

    @Override
    public boolean handle(final Context context) {
        Character currentCharacter = context.getCurrentCharacter();

        if (currentCharacter.equals(permanentContext.getOpenBrace()) ||
                currentCharacter.equals(permanentContext.getCloseBrace()) ||
                currentCharacter.equals(permanentContext.getSpace()) ||
                currentCharacter.equals(permanentContext.getSemicolon()) ||
                currentCharacter.equals(permanentContext.getNewLine())) {
            return false;
        }

        context.setFormattedString(currentCharacter.toString());
        return true;
    }
}
