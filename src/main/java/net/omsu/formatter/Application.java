package net.omsu.formatter;

import net.omsu.formatter.ioc.DependencyFactory;
import net.omsu.formatter.ioc.GuiceDependencyFactory;
import net.omsu.formatter.formatter.Formatter;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 *
 */
public class Application {

    public static void main(String[] args) throws Exception {
        DependencyFactory dependencyFactory = new GuiceDependencyFactory();

        Reader reader = dependencyFactory.buildReader();
        Writer writer = dependencyFactory.buildWriter();

        Formatter formatter = dependencyFactory.buildFormatter();
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }
}
