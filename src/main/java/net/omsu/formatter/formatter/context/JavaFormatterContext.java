package net.omsu.formatter.formatter.context;

/**
 *
 */
public class JavaFormatterContext implements Context {

    private Character lastCharacter;
    private Character currentCharacter;
    private String formatterString = "";
    private int nestingLevel;

    public JavaFormatterContext() {
    }

    @Override
    public Character getCurrentCharacter() {
        return currentCharacter;
    }

    @Override
    public Character getLastCharacter() {
        return lastCharacter;
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
    public void setCurrentCharacter(Character currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void setLastCharacter(Character lastCharacter) {
        this.lastCharacter = lastCharacter;
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
        if (lastCharacter != null ? !lastCharacter.equals(that.lastCharacter) : that.lastCharacter != null)
            return false;
        if (currentCharacter != null ? !currentCharacter.equals(that.currentCharacter) : that.currentCharacter != null)
            return false;
        return !(formatterString != null ? !formatterString.equals(that.formatterString) : that.formatterString != null);
    }

    @Override
    public int hashCode() {
        int result = lastCharacter != null ? lastCharacter.hashCode() : 0;
        result = 31 * result + (currentCharacter != null ? currentCharacter.hashCode() : 0);
        result = 31 * result + (formatterString != null ? formatterString.hashCode() : 0);
        result = 31 * result + nestingLevel;
        return result;
    }
}
