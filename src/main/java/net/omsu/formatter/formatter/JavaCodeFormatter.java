package net.omsu.formatter.formatter;

import com.google.common.collect.ImmutableMap;
import net.omsu.formatter.exception.GeneralException;
import net.omsu.formatter.formatter.handlers.CharHandler;
import net.omsu.formatter.formatter.handlers.CloseBraceHandler;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.formatter.handlers.NewLineHandler;
import net.omsu.formatter.formatter.handlers.OpenBraceHandler;
import net.omsu.formatter.formatter.handlers.SemicolonHandler;
import net.omsu.formatter.formatter.handlers.SpaceHandler;
import net.omsu.formatter.reader.FileReader;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.FileWriter;
import net.omsu.formatter.writer.Writer;

import java.util.Map;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {

    private final Map<Status, Handler> mapOfHandlers = ImmutableMap.<Status, Handler>builder()
            .put(Status.CHAR, new CharHandler())
            .put(Status.SPACE, new SpaceHandler())
            .put(Status.OPEN_BRACE, new OpenBraceHandler())
            .put(Status.CLOSE_BRACE, new CloseBraceHandler())
            .put(Status.SEMICOLON, new SemicolonHandler())
            .put(Status.NEW_LINE, new NewLineHandler())
            .build();

    public JavaCodeFormatter() {
    }

    @Override
    public void format(final Reader reader, final Writer writer) throws GeneralException {

        int nestingLevel = 0;
        Status lastStatus = Status.CHAR;

        while (reader.hasNext()) {
            char character = reader.read();
            Status currentStatus = Status.getStatus(character);

            switch (currentStatus) {
                case OPEN_BRACE: {
                    nestingLevel++;

                    if (lastStatus != Status.SPACE) {
                        writer.write(mapOfHandlers.get(Status.SPACE).handle(character, nestingLevel));
                    }
                    writer.write(mapOfHandlers.get(Status.OPEN_BRACE).handle(character, nestingLevel));
                    writer.write(mapOfHandlers.get(Status.NEW_LINE).handle(character, nestingLevel));
                    break;
                }
                case CLOSE_BRACE: {
                    nestingLevel--;

                    writer.write(mapOfHandlers.get(Status.NEW_LINE).handle(character, nestingLevel));
                    writer.write(mapOfHandlers.get(Status.CLOSE_BRACE).handle(character, nestingLevel));
                    writer.write(mapOfHandlers.get(Status.NEW_LINE).handle(character, nestingLevel));
                    break;
                }
                case SEMICOLON: {

                    writer.write(mapOfHandlers.get(Status.SEMICOLON).handle(character, nestingLevel));
                    writer.write(mapOfHandlers.get(Status.NEW_LINE).handle(character, nestingLevel));
                    break;
                }
                case SPACE: {
                    if (lastStatus == Status.CHAR) {
                        writer.write(mapOfHandlers.get(Status.SPACE).handle(character, nestingLevel));
                    }
                    break;
                }
                case CHAR: {
                    writer.write(mapOfHandlers.get(Status.CHAR).handle(character, nestingLevel));
                    break;
                }
            }

            lastStatus = currentStatus;
        }
    }


    public static void main(String[] args) throws GeneralException {

        Reader reader = new FileReader("format.java");
        Writer writer = new FileWriter("output.java");

        Formatter formatter = new JavaCodeFormatter();
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }
}
