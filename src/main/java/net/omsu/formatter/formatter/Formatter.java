package net.omsu.formatter.formatter;

import net.omsu.formatter.formatter.strategy.ReaderStrategy;
import net.omsu.formatter.writer.Writer;

/**
 * Interface for formatting some kind of data.
 */
public interface Formatter {

    void format(final ReaderStrategy readerStrategy, final Writer writer);
}
