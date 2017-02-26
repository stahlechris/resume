package tradersandtransactionsstreams;

/**
 *
 * @author stahl
 */
public class Trader {
    private String name;
    private String city;
    
    Trader(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "Trader:" +this.name + " in " + this.city;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
