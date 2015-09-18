package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 *
 */
public class SpaceHandler implements BiFunction<Character, Integer, String> {

    public SpaceHandler() {
    }

    @Override
    public String apply(Character character, Integer integer) {
        return " ";
    }
}
