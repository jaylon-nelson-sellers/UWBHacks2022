import java.io.*;
import java.util.ArrayList;

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

public class main{

    /**
     * Main
     * Executes file
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) {
        testMethod();

    }

    /**
     * Tests currently working files through example vtt (Avengers)
     * @throws IOException
     */
    public static void testMethod() {
        try {
            VttObject testObject = new VttObject(new BufferedReader(new FileReader("Avengers_Endgame.vtt")));
            ArrayList<String> testArray = testObject.getLines();

            for (int i = 0; i < testArray.size(); i++)
            {
                System.out.println(testArray.get(i));
            }
        }
        catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        }


    }
}
