package recipesortingusingstreams;
//author : christopher stahle
import java.util.*;
import static java.util.stream.Collectors.toList;

public class RecipeSortingUsingStreams {

    public static void main(String[] args) {
        MealsTextFile mtf = new MealsTextFile();
        List<Meal> mealsList = mtf.getInput();
        //easy sorting!
        List<String> highCalorieMealNames = 
            mealsList.stream()
            .filter (m -> m.getCalories() > 60)
            .map(Meal::getName)
            .collect(toList());
        
        System.out.println(highCalorieMealNames);

    }

}
