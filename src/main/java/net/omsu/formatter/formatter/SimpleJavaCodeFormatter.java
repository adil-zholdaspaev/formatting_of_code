package net.omsu.formatter.formatter;

import org.apache.commons.lang3.StringUtils;

import java.lang.String;

/**
 *
 */
public class SimpleJavaCodeFormatter implements Formatter {

    private final static String TAB = "     ";
    private final static char OPEN_BRACE = '{';
    private final static char CLOSE_BRACE = '}';
    private final static char SPACE = ' ';
    private final static char SEMICOLON = ';';
    private final static char NEW_LINE = '\n';

    private int openBraces = 0;
    private boolean isNewLine = false;

    public SimpleJavaCodeFormatter() {

    }

    @Override
    public String format(final String line) {

        final StringBuilder formattedLine = new StringBuilder();

        for (String word : line.split(" ")) {
            if (StringUtils.isBlank(word)) {
                continue;
            }

            for (char sing : word.toCharArray()) {

                switch (sing) {
                    case OPEN_BRACE : {
                        openBraces++;

                        formattedLine.append(OPEN_BRACE);
                        newLine(formattedLine);

                        break;
                    }
                    case CLOSE_BRACE : {
                        openBraces--;

                        newLine(formattedLine);
                        formattedLine.append(CLOSE_BRACE);
                        newLine(formattedLine);

                        break;
                    }
                    case SEMICOLON : {

                        formattedLine.append(SEMICOLON);
                        newLine(formattedLine);

                        break;
                    }
                    default : {
                        formattedLine.append(sing);
                        isNewLine = true;
                    }
                }
            }

            if (isNewLine) {
                isNewLine = false;
            } else {
                formattedLine.append(SPACE);
            }
        }


        return formattedLine.toString();
    }

    private void newLine(final StringBuilder formattedLine) {
        formattedLine.append(NEW_LINE);
        for (int i = 0; i < openBraces; i++) {
            formattedLine.append(TAB);
        }
    }

    private void format(final StringBuilder stringBuilder, final String word) {
    }
}
