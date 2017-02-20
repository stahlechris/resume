package recipesortingusingstreams;

public class Meal {

    private String name;
    private int calories;
    private int protein;
    private int fat;
    private int carbs;
    private int sugar;

    Meal() {
        super();
        name = "";
    }

    Meal(String name, int calories, int protein, int fat, int carbs, int sugar) {
        this.name = name;
        this.calories=calories;
        this.protein=protein;
        this.fat=fat;
        this.carbs=carbs;
        this.sugar=sugar;
    }

    /**
     * @return the calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * @return the carbs
     */
    public int getCarbs() {
        return carbs;
    }

    /**
     * @param carbs the carbs to set
     */
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    /**
     * @return the sugar
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * @param sugar the sugar to set
     */
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the protein
     */
    public int getProtein() {
        return protein;
    }

    /**
     * @param protein the protein to set
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }

    /**
     * @return the fat
     */
    public int getFat() {
        return fat;
    }

    /**
     * @param fat the fat to set
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

}
