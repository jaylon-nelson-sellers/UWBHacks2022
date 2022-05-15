import java.io.*;
import java.util.ArrayList;

/**
 * VttObject class
 * reads a VTT file and creates a arraylist for easy access
 */
public class VttObject {

    //variable to store lines
    ArrayList<String> lines;

    /**
     * Default Constructor
     * creates object
     *
     */
    public VttObject() {
        lines = null;
    }

    /**
     * VttObject with BufferedReader
     * reads in Vtt File and initialized method that interprets it.
     * @param inStream input stream from Vtt file
     */
    public VttObject(BufferedReader inStream) {
        lines = new ArrayList<String>();
        try {
            boolean start = false;
            String curLine = " ";
            while ((curLine = inStream.readLine()) != null){
                //checks if beginning of file
                if (!start) {
                    start = true;
                    continue;
                }

                if(!checkLine(curLine)) continue;
                lines.add(curLine);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * checkLine
     * checks the given string to eliminate none essential lines
     * @param currentLine current line being examined
     * @return a boolean representing if the line can be added to the array
     */
    private static boolean checkLine(String currentLine) {
        //checks conditions
        //empty line
        if (currentLine == " " || currentLine.isEmpty()) return false;
        //timestamp
        if (currentLine.contains("-->")) return false;
        //only numerical values (index)
        if (currentLine.matches("[0-9]+")) return false;
        return true;
    }

    /**
     * returns ArrayList line
     * @return ArrayList of lines
     */
    public ArrayList getLines() {
        return lines;
    }
}
