package net.omsu.formatter.formatter.context;

/**
 *
 */
public class JavaPermanentContext {

    private String openBrace;
    private String closeBrace;
    private String semicolon;
    private String space;
    private String newLine;
    private String tab;

    private JavaPermanentContext() {
    }

    public String getOpenBrace() {
        return openBrace;
    }

    public String getCloseBrace() {
        return closeBrace;
    }

    public String getSemicolon() {
        return semicolon;
    }

    public String getSpace() {
        return space;
    }

    public String getNewLine() {
        return newLine;
    }

    public String getTab() {
        return tab;
    }

    public static Builder newBuilder() {
        return new JavaPermanentContext().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setOpenBrace(final String openBrace) {
            JavaPermanentContext.this.openBrace = openBrace;
            return this;
        }

        public Builder setCloseBrace(final String closeBrace) {
            JavaPermanentContext.this.closeBrace = closeBrace;
            return this;
        }

        public Builder setSemicolon(final String semicolon) {
            JavaPermanentContext.this.semicolon = semicolon;
            return this;
        }

        public Builder setSpace(final String space) {
            JavaPermanentContext.this.space = space;
            return this;
        }

        public Builder setNewLine(final String newLine) {
            JavaPermanentContext.this.newLine = newLine;
            return this;
        }

        public Builder setTab(final String tab) {
            JavaPermanentContext.this.tab = tab;
            return this;
        }

        public JavaPermanentContext build() {
            return JavaPermanentContext.this;
        }
    }
}
