package net.omsu.formatter.formatter;

import net.omsu.formatter.exception.ReaderException;
import net.omsu.formatter.exception.WriterException;
import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.ContextKeys;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {

    private final List<Handler> handles;

    public JavaCodeFormatter(final List<Handler> handlers) {
        this.handles = handlers;
    }

    @Override
    public void format(final Reader reader, final Writer writer) throws ReaderException, WriterException {

        final Context context = new Context();
        context.set(ContextKeys.LAST_CHARACTER, '\n');
        context.set(ContextKeys.NESTING_LEVEL, 0);

        while (reader.hasNext()) {
            char character = reader.read();
            context.set(ContextKeys.CURRENT_CHARACTER, character);

            handles.forEach(handler -> handler.handle(context));

            Optional<String> result = context.get(ContextKeys.RESULT, String.class);

            if (result.isPresent()) {
                writer.write(result.get());
            }

            context.set(ContextKeys.LAST_CHARACTER, character);
            context.remove(ContextKeys.CURRENT_CHARACTER);
            context.remove(ContextKeys.RESULT);
        }
    }
}
