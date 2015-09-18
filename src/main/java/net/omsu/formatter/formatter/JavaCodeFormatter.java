package net.omsu.formatter.formatter;

import net.omsu.formatter.exception.GeneralException;
import net.omsu.formatter.reader.Reader;
import net.omsu.formatter.writer.Writer;

/**
 *
 */
public class JavaCodeFormatter implements Formatter {



    public JavaCodeFormatter() {
    }

    @Override
    public void format(Reader reader, Writer writer) throws GeneralException {
        Integer level = 0;

        Status lastStatus = Status.CHAR;

        while (reader.hasNext()) {
            char character = reader.read();
            Status currentStatus = Status.getStatus(character);



            /*
            * handle.apply(character, level)
            *
            *
            * */


        }

    }
}
