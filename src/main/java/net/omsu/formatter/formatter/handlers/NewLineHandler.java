package net.omsu.formatter.formatter.handlers;

/**
 *
 */
public class NewLineHandler implements Handler {

    public NewLineHandler() {
    }

    @Override
    public String handle(final Character character, final int nestingLevel) {
        final StringBuilder result = new StringBuilder();
        result.append('\n');
        for (int i = 0; i < nestingLevel; i++) {
            result.append("    ");
        }

        return result.toString();
    }
}
