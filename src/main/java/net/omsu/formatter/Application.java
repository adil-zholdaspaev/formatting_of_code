package net.omsu.formatter;

import net.omsu.formatter.exception.ReaderException;
import net.omsu.formatter.exception.WriterException;
import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.formatter.JavaCodeFormatter;
import net.omsu.formatter.formatter.handlers.CharHandler;
import net.omsu.formatter.formatter.handlers.CloseBraceHandler;
import net.omsu.formatter.formatter.handlers.Handler;
import net.omsu.formatter.formatter.handlers.OpenBraceHandler;
import net.omsu.formatter.formatter.handlers.SemicolonHandler;
import net.omsu.formatter.formatter.handlers.SpaceHandler;
import net.omsu.formatter.reader.FileReader;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.FileWriter;
import net.omsu.formatter.writer.Writer;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Application {

    public Application() throws WriterException, ReaderException {
        Reader reader = new FileReader("format.java");
        Writer writer = new FileWriter("output.java");

        List<Handler> handlers = new LinkedList<>();
        handlers.add(new OpenBraceHandler());
        handlers.add(new CloseBraceHandler());
        handlers.add(new SemicolonHandler());
        handlers.add(new SpaceHandler());
        handlers.add(new CharHandler());

        Formatter formatter = new JavaCodeFormatter(handlers);
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws ReaderException, WriterException {
        new Application();
    }
}
