package net.omsu.formatter.reader;

import com.google.common.io.Resources;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FileReaderTest {

    public FileReader setUp(final String fileName) throws ReaderException {
        final URL url = Resources.getResource(fileName);
        return new FileReader(url.getFile());
    }

    public void tearDown(final FileReader reader) throws ReaderException {
        reader.close();
    }

    @Test
    public void testFileReader() throws ReaderException {
        final FileReader reader = setUp("FileReaderTest.java");

        final String expectedValues = "This" + System.lineSeparator() + "is.";

        int index = 0;
        while (reader.hasNext()) {
            char character = reader.read();
            assertEquals(expectedValues.charAt(index), character);
            index++;
        }
        assertEquals(expectedValues.length(), index);

        tearDown(reader);
    }

    @Test(expected = ReaderException.class)
    public void testFileNotFound() throws ReaderException {
        new FileReader("FileNotFound");
    }

    @Test(expected = ReaderException.class)
    public void testFileNameIsNull() throws ReaderException {
        new FileReader(null);
    }
}
