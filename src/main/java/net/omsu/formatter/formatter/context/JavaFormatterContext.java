package net.omsu.formatter.formatter.context;

/**
 *
 */
public class JavaFormatterContext implements Context {

    private String lastCharacters;
    private String currentCharacters;
    private String formatterString = "";
    private int nestingLevel;

    public JavaFormatterContext() {
    }

    @Override
    public String getCurrentCharacters() {
        return currentCharacters;
    }

    @Override
    public String getLastCharacters() {
        return lastCharacters;
    }

    @Override
    public String getFormattedString() {
        return formatterString;
    }

    @Override
    public int getNestingLevel() {
        return nestingLevel;
    }

    @Override
    public void setCurrentCharacters(String currentCharacters) {
        this.currentCharacters = currentCharacters;
    }

    @Override
    public void setLastCharacters(String lastCharacters) {
        this.lastCharacters = lastCharacters;
    }

    @Override
    public void setFormattedString(String formattedString) {
        this.formatterString = formattedString;
    }

    @Override
    public void setNestingLevel(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaFormatterContext that = (JavaFormatterContext) o;

        if (nestingLevel != that.nestingLevel) return false;
        if (lastCharacters != null ? !lastCharacters.equals(that.lastCharacters) : that.lastCharacters != null)
            return false;
        if (currentCharacters != null ? !currentCharacters.equals(that.currentCharacters) : that.currentCharacters != null)
            return false;
        return !(formatterString != null ? !formatterString.equals(that.formatterString) : that.formatterString != null);

    }

    @Override
    public int hashCode() {
        int result = lastCharacters != null ? lastCharacters.hashCode() : 0;
        result = 31 * result + (currentCharacters != null ? currentCharacters.hashCode() : 0);
        result = 31 * result + (formatterString != null ? formatterString.hashCode() : 0);
        result = 31 * result + nestingLevel;
        return result;
    }
}
