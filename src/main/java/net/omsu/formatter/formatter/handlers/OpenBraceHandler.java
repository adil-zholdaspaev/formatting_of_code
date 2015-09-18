package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 *
 */
public class OpenBraceHandler implements BiFunction<Character, Integer, String> {

    public OpenBraceHandler() {
    }

    @Override
    public String apply(Character character, Integer integer) {
        return " {";
    }
}
