package net.omsu.formatter.formatter;

import net.omsu.formatter.reader.ReaderException;
import net.omsu.formatter.writer.WriterException;
import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.factory.ContextFactory;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

import java.util.List;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {

    private final ContextFactory contextFactory;
    private final List<Handler> handlers;

    public JavaCodeFormatter(final List<Handler> handlers, final ContextFactory contextFactory) {
        this.contextFactory = contextFactory;
        this.handlers = handlers;
    }

    @Override
    public void format(final Reader reader, final Writer writer) throws ReaderException, WriterException {

        final Context context = contextFactory.getContext();
        context.setLastCharacter('\n');
        context.setNestingLevel(0);

        while (reader.hasNext()) {
            context.setCurrentCharacter(reader.read());
            handlers.forEach(handler -> handler.handle(context));

            writer.write(context.getFormattedString());

            context.setLastCharacter(context.getCurrentCharacter());
            context.setFormattedString("");
        }
    }
}
