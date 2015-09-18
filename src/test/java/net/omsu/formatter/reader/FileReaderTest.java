package net.omsu.formatter.reader;

import com.google.common.io.Resources;
import net.omsu.formatter.exception.GeneralException;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FileReaderTest {

    public FileReader setUp(final String fileName) throws GeneralException {
        final URL url = Resources.getResource(fileName);
        return new FileReader(url.getFile());
    }

    public void tearDown(final FileReader reader) throws GeneralException {
        reader.close();
    }

    @Test
    public void testFileReader() throws GeneralException {
        final FileReader reader = setUp("FileReaderTest.java");

        final String expectedValues = "This\nis\na\ntest\nfile\nreader.";

        int index = 0;
        while (reader.hasNext()) {
            char character = reader.read();
            assertEquals(expectedValues.charAt(index), character);
            index++;
        }
        assertEquals(expectedValues.length(), index);

        tearDown(reader);
    }

    @Test(expected = GeneralException.class)
    public void testFileNotFound() throws GeneralException {
        new FileReader("FileNotFound");
    }

    @Test(expected = GeneralException.class)
    public void testFileNameIsNull() throws GeneralException {
        new FileReader(null);
    }
}
