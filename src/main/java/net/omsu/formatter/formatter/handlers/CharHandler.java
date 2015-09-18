package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 *
 */
public class CharHandler implements BiFunction<Character, Integer, String> {

    @Override
    public String apply(Character character, Integer integer) {
        return character.toString();
    }
}
