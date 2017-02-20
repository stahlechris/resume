package recipesortingusingstreams;

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
public class MealsTextFile {

    private ArrayList<Meal> inputArrayList = null;
    private Path readersPath = null;
    private File readersFile = null;
    private final String DELIMITER = System.getProperty("line.separator");

    public MealsTextFile() {
        readersPath = Paths.get("src/recipesortingusingstreams/meals.txt");
        readersFile = readersPath.toFile();
        inputArrayList = getInput();
    }

    public ArrayList<Meal> getInput() {

        if (inputArrayList != null) {
            return inputArrayList;
        }
        inputArrayList = new ArrayList<>();

        if (Files.exists(readersPath)) {
            try (BufferedReader in
                    = new BufferedReader(
                            new FileReader(readersFile))) {
                String line = "";
                while ( (line = in.readLine()) != null) {
                    String[] tokens = line.split(", "); //get each line's values with this
                    String name = tokens[0];
                    int calories = Integer.parseInt(tokens[1]);
                    int protein = Integer.parseInt(tokens[2]);
                    int fat = Integer.parseInt(tokens[3]);
                    int carbs = Integer.parseInt(tokens[4]);
                    int sugar = Integer.parseInt(tokens[5]);
                   
                    Meal m = new Meal(name, calories, protein, fat, carbs, sugar);
                    inputArrayList.add(m);
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
