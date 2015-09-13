package net.omsu.formatter.reader;

import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class FileReaderTest {

    private FileReader reader;

    @Before
    public void setUp() throws FileNotFoundException {
        String fileName = "reader.java";

        URL url = Resources.getResource(fileName);
        reader = new FileReader(url.getFile());
    }

    @After
    public void tearDown() throws IOException {
        reader.close();
    }

    @Test
    public void testFileReader() throws IOException {

        int linesInFile = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            assertNotNull(line);
            linesInFile++;
        }

        assertEquals(6, linesInFile);
    }
}
