package net.omsu.formatter.formatter;

/**
 *
 */
public enum Status {

    CHAR,
    NEW_LINE,
    SPACE,
    OPEN_BRACE,
    CLOSE_BRACE,
    SEMICOLON;

    public static Status getStatus(final char character) {
        switch (character) {
            case ' ' : return SPACE;
            case ';' : return SEMICOLON;
            case '{' : return OPEN_BRACE;
            case '}' : return CLOSE_BRACE;
            case '\n': return NEW_LINE;
            default  : return CHAR;
        }
    }
}
