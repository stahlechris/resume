package vendingmachine;

public class CashRegister {

    private static final double QUARTER_VALUE = 0.25;
    private static final double DOLLAR_VALUE = 1.00;

    private int numDollars;
    private int numQuarters;
    private double total;

    CashRegister() {
        numDollars = 0;
        numQuarters = 0;
        total = adjustTotal(numDollars, numQuarters);
    }

    public void adjustNumDollars(int adjuster) { //On second thought..this might be TOO encapsulated!!
        if (adjuster == -1) {
            setNumDollars(getNumDollars() - 1);
        } else if (adjuster == 1) {
            setNumDollars(getNumDollars() + 1);
        }
        adjustTotal(getNumDollars(), getNumQuarters());
    }

    public void adjustNumQuarters(int adjuster) {
        if (adjuster == -1) {
            setNumQuarters(getNumQuarters() - 1);
        } else if (adjuster == 1) {
            setNumQuarters(getNumQuarters() + 1);
        }
        adjustTotal(getNumQuarters(), getNumDollars());
    }

    public double adjustTotal(int numDollars, int numQuarters) {
        //based on the number of quarters and dollars, calculate the total
        total = (QUARTER_VALUE * numQuarters) + (DOLLAR_VALUE * numDollars);
        //TURN OFF THE LIGHTS HERE
        return total;
    }

    /**
     * @return the numDollars
     */
    public int getNumDollars() {
        return numDollars;
    }

    /**
     * @param numDollars the numDollars to set
     */
    public void setNumDollars(int numDollars) {
        this.numDollars = numDollars;
    }

    /**
     * @return the numQuarters
     */
    public int getNumQuarters() {
        return numQuarters;
    }

    /**
     * @param numQuarters the numQuarters to set
     */
    public void setNumQuarters(int numQuarters) {
        this.numQuarters = numQuarters;
    }

    public double refund() { //maybe a misleading name
        return total;
    }

    public void emptyTheCashRegister() {
        System.out.println("There are currently " + getNumDollars() + " dollars in here.....");
        System.out.println("There are currently " + getNumQuarters() + " quarters in here....");
        System.out.println("The total currently is " + adjustTotal(getNumDollars(), getNumQuarters()));
        System.out.println("Im getting rid of all the dollars...");
        //DEPRECATED FOR SHALOM'S ANTI-LOOP VERSION...duh!!!
        /*
        while (getNumDollars() > 0) { //THIS NEEDS TO GO RECURSIVELY
            adjustNumDollars(-1);
        }
        System.out.println("Im getting rid of all the quarters...");
        
        while (getNumQuarters() > 0) {
            adjustNumQuarters(-1);
        }
            */
        this.setNumDollars(0);
        this.setNumQuarters(0);
        System.out.println("Your total should be 0...->"+refund());
    }
}
