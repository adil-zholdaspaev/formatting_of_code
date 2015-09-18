package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 * Created by adzoldaspaev on 9/18/15.
 */
public class CloseBraceHandler implements BiFunction<Character, Integer, String> {

    public CloseBraceHandler() {
    }

    @Override
    public String apply(Character character, Integer integer) {
        final StringBuilder result = new StringBuilder();
        result.append('\n');
        for (int i = 0; i < integer - 1; i++) {
            result.append("    ");
        }
        result.append("}");

        return result.toString();
    }
}
