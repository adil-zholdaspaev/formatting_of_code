package net.omsu.formatter.formatter.context.factory;

import net.omsu.formatter.formatter.context.Context;
import net.omsu.formatter.formatter.context.JavaFormatterContext;

/**
 *
 */
public class JavaContextFactory implements ContextFactory {

    public JavaContextFactory() {
    }

    @Override
    public Context getContext() {
        return new JavaFormatterContext();
    }
}
