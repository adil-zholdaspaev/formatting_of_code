package net.omsu.formatter.formatter.handlers;

import java.util.function.BiFunction;

/**
 * Created by adzoldaspaev on 9/18/15.
 */
public class NewWordHandler implements BiFunction<Character, Integer, String> {

    public NewWordHandler() {
    }

    @Override
    public String apply(Character character, Integer integer) {
        return " " + character.toString();
    }
}
