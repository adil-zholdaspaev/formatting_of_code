package net.omsu.formatter.core;

import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.formatter.SimpleJavaCodeFormatter;
import net.omsu.formatter.reader.FileReader;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.FileWriter;
import net.omsu.formatter.writer.Writer;

import java.io.IOException;

/**
 *
 */
public class Manager {

    private Reader reader;
    private Writer writer;
    private Formatter formatter;

    public Manager(final String readerFileName,
                   final String writerFileName) throws IOException {

        reader = new FileReader(readerFileName);
        writer = new FileWriter(writerFileName);
        formatter = new SimpleJavaCodeFormatter();
    }

    public void manage() throws IOException {

        String line;
        while ((line = reader.readLine()) != null) {
            String formatCode = formatter.format(line);
            writer.writeLine(formatCode);
        }

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager("format.java", "output.java");
        manager.manage();
    }
}
