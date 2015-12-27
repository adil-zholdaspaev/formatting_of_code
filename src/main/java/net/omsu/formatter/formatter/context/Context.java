package net.omsu.formatter.formatter.context;

/**
 * Class contain some metadata.
 */
public interface Context {

    String getCurrentCharacters();
    String getLastCharacters();
    String getFormattedString();
    int getNestingLevel();

    void setCurrentCharacters(String currentCharacters);
    void setLastCharacters(String lastCharacters);
    void setFormattedString(String formattedString);
    void setNestingLevel(int nestingLevel);
}
