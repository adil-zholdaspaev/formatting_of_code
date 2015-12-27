package net.omsu.formatter.formatter;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.factory.ContextFactory;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.formatter.strategy.ReaderStrategy;
import net.omsu.formatter.writer.Writer;

import java.util.Map;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {

    private final ContextFactory contextFactory;
    private final Map<String, Handler> handlers;
    private final Handler charHandler;

    public JavaCodeFormatter(final Map<String, Handler> handlers, final ContextFactory contextFactory) {
        this.contextFactory = contextFactory;
        this.charHandler = handlers.get("default");
        this.handlers = handlers;
    }

    @Override
    public void format(final ReaderStrategy readerStrategy, final Writer writer) {

        final Context context = contextFactory.getContext();
        context.setLastCharacters("\n");
        context.setNestingLevel(0);

        String value;
        while ((value = readerStrategy.getNext()) != null) {
            context.setCurrentCharacters(value);

            handlers.getOrDefault(value, charHandler).handle(context);
            writer.write(context.getFormattedString());

            context.setLastCharacters(context.getCurrentCharacters());
            context.setFormattedString("");
        }
    }
}
