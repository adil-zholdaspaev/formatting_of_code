package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 * Created by adzoldaspaev on 9/18/15.
 */
public class NewLineHandler implements BiFunction<Character, Integer, String> {

    public NewLineHandler() {
    }

    @Override
    public String apply(Character character, Integer integer) {
        final StringBuilder result = new StringBuilder();
        result.append('\n');
        for (int i = 0; i < integer; i++) {
            result.append("    ");
        }

        return result.toString();
    }
}
