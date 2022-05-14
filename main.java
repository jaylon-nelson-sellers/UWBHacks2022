import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * vttlibrary
 * main
 *  runs code
 *
 * class keyword
 *      parse VVT
 *      createkeywordlist
 *      outputkeywords
 *      setLinks
 *      getlinks
 *
 */


import fr.noop.subtitle.model.SubtitleParsingException;
import fr.noop.subtitle.vtt.*;

public class main{

    /**
     * Main
     * Executes file
     * @param args
     * @throws IOException
     * @throws SubtitleParsingException
     */
    public static void main(String args[])throws IOException, SubtitleParsingException  {
        testMethod();

    }

    /**
     * Tests currently working files through example vtt (Avengers)
     * @throws IOException
     * @throws SubtitleParsingException
     */
    public static void testMethod() throws IOException, SubtitleParsingException {
    }
}
