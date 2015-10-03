package net.omsu.formatter.formatter.context;

/**
 * Class contain some metadata.
 */
public interface Context {

    Character getCurrentCharacter();
    Character getLastCharacter();
    String getFormattedString();
    int getNestingLevel();

    void setCurrentCharacter(Character currentCharacter);
    void setLastCharacter(Character lastCharacter);
    void setFormattedString(String formattedString);
    void setNestingLevel(int nestingLevel);
}
