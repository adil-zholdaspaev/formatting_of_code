package net.omsu.formatter.formatter;

import net.omsu.formatter.exception.GeneralException;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 * Interface for formatting some kind of data.
 */
public interface Formatter {

    public void format(final Reader reader, final Writer writer) throws GeneralException;
}
