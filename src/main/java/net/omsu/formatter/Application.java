package net.omsu.formatter;

import net.omsu.formatter.ioc.BeansFactory;
import net.omsu.formatter.ioc.JavaBeansFactory;
import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 *
 */
public class Application {

    public static void main(String[] args) {
        BeansFactory beansFactory = new JavaBeansFactory();

        Reader reader = beansFactory.buildReader();
        Writer writer = beansFactory.buildWriter();

        Formatter formatter = beansFactory.buildFormatter();
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }
}
