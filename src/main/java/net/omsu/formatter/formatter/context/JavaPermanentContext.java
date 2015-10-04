package net.omsu.formatter.formatter.context;

/**
 *
 */
public class JavaPermanentContext {

    private char openBrace = '{';
    private char closeBrace = '}';
    private char semicolon = ';';
    private char space = ' ';
    private char newLine = '\n';
    private String tab = "    ";
    private char openBracket = '(';
    private char closeBracket = ')';

    private JavaPermanentContext() {
    }

    public char getOpenBrace() {
        return openBrace;
    }

    public char getCloseBrace() {
        return closeBrace;
    }

    public char getSemicolon() {
        return semicolon;
    }

    public char getSpace() {
        return space;
    }

    public char getNewLine() {
        return newLine;
    }

    public String getTab() {
        return tab;
    }

    public char getOpenBracket() {
        return openBracket;
    }

    public char getCloseBracket() {
        return closeBracket;
    }

    public static Builder newBuilder() {
        return new JavaPermanentContext().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setOpenBrace(final char openBrace) {
            JavaPermanentContext.this.openBrace = openBrace;
            return this;
        }

        public Builder setCloseBrace(final char closeBrace) {
            JavaPermanentContext.this.closeBrace = closeBrace;
            return this;
        }

        public Builder setSemicolon(final char semicolon) {
            JavaPermanentContext.this.semicolon = semicolon;
            return this;
        }

        public Builder setSpace(final char space) {
            JavaPermanentContext.this.space = space;
            return this;
        }

        public Builder setNewLine(final char newLine) {
            JavaPermanentContext.this.newLine = newLine;
            return this;
        }

        public Builder setTab(final String tab) {
            JavaPermanentContext.this.tab = tab;
            return this;
        }

        public Builder setOpenBracket(final char openBracket) {
            JavaPermanentContext.this.openBracket = openBracket;
            return this;
        }

        public Builder setCloseBracket(final char closeBracket) {
            JavaPermanentContext.this.closeBracket = closeBracket;
            return this;
        }

        public JavaPermanentContext build() {
            return JavaPermanentContext.this;
        }
    }
}
