package net.omsu.formatter.formatter;

import com.google.common.collect.ImmutableMap;
import net.omsu.formatter.exception.GeneralException;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {

    private final static ImmutableMap<Character, Status> statuses = ImmutableMap.<Character, Status>builder()
            .put(' ', Status.SPACE)
            .put(';', Status.SEMICOLON)
            .put('{', Status.OPEN_BRACE)
            .put('}', Status.CLOSE_BRACE)
            .put('a', Status.CHAR)
            .build();

    @Override
    public void format(Reader reader, Writer writer) throws GeneralException {

    }
}
