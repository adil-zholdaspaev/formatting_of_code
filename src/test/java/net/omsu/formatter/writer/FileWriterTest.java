package net.omsu.formatter.writer;

import net.omsu.formatter.reader.ReaderException;
import net.omsu.formatter.reader.FileReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FileWriterTest {

    public FileWriter setUp(final String fileName) throws WriterException {
        return new FileWriter(fileName);
    }

    public void tearDown(final FileWriter reader) throws WriterException {
        reader.close();
    }

    @Test
    public void testFileWriter() throws WriterException, ReaderException {
        final String fileName = "FileWriterTest.java";

        final FileWriter writer = setUp(fileName);
        final String expectedValues = "This" + System.lineSeparator() + "is.";
        writer.write(expectedValues);
        tearDown(writer);

        final FileReader reader = new FileReader(fileName);
        int index = 0;
        while (reader.hasNext()) {
            char character = reader.read();
            assertEquals(expectedValues.charAt(index), character);
            index++;
        }
        assertEquals(expectedValues.length(), index);
        reader.close();
    }

    @Test
    public void testFileWriterClose() throws WriterException, ReaderException {
        final String fileName = "FileWriterTest.java";

        final FileWriter writer = setUp(fileName);
        final String expectedValues = "Test writer, close writer";
        writer.write(expectedValues);
        tearDown(writer);
        writer.write("Not saved in file");

        final FileReader reader = new FileReader(fileName);
        int index = 0;
        while (reader.hasNext()) {
            char character = reader.read();
            assertEquals(expectedValues.charAt(index), character);
            index++;
        }
        assertEquals(expectedValues.length(), index);
        reader.close();
    }

    @Test(expected = WriterException.class)
    public void testFileNameIsNull() throws WriterException {
        new FileWriter(null);
    }
}
