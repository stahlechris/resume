package tradersandtransactionsstreams;

/**
 *
 * @author stahl
 */
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
    
    public Transaction(Trader trader, int year, int value)
    {
        this.trader=trader;
        this.year=year;
        this.value=value;
    }
    @Override
    public String toString()
    {
        return "{" + this.trader + ", " + 
                "year: "+this.year+", " +
                "value:" + this.value +"}\n";
    }
    /**
     * @return the trader
     */
    public Trader getTrader() {
        return trader;
    }

    /**
     * @param trader the trader to set
     */
    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
}
