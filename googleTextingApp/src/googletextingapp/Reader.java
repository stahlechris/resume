package googletextingapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author chris stahle
 */
public class Reader {

    private ArrayList<String> inputArrayList = null;
    private Path readersPath = null;
    private File readersFile = null;
    private final String DELIMITER = System.getProperty("line.separator");

    public Reader() {
        readersPath = Paths.get("src/googleTextingApp/C-small-practice.txt");
        readersFile = readersPath.toFile();
        inputArrayList = getInput();
    }

    public ArrayList<String> getInput() {

        if (inputArrayList != null) {
            return inputArrayList;
        }
        inputArrayList = new ArrayList<>();

        if (Files.exists(readersPath)) {
            try (BufferedReader in
                    = new BufferedReader(
                            new FileReader(readersFile))) {
                String line = in.readLine(); //first line is an int - num of usable lines after this
                inputArrayList.add(line);
                while ( (line = in.readLine()) != null) {
                    //String[] tokens = line.split(DELIMITER); //get all lines with this
                    //line = in.readLine();
                    inputArrayList.add(line);
                }
            } catch (IOException e) //!FileNotFoundException inherits from IOException!
            {
                e.printStackTrace();
                return null;
            }
        }
        return inputArrayList;
    }

}
