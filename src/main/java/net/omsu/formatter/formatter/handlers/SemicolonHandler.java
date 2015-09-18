package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 *
 */
public class SemicolonHandler implements BiFunction<Character, Integer, String> {

    public SemicolonHandler() {
    }

    @Override
    public String apply(Character character, Integer nestedLevel) {
        return ";";
    }
}
