//this is the guy that loads a VendingMachine
package vendingmachine;

public class VendingMachineLoader {

    //I loaded this pallette myself, i know theres only 10 of each type of Beverage
    private static final int SIZE = 10;
    //Here's all the Beverages in the pallette

    public Beverage pepsi = new Beverage("Pepsi", 1, 10); //Here's 10 pepsi's, that are $1.00 each
    protected Beverage coke = new Beverage("Coke", 1, 10);
    protected Beverage sprite = new Beverage("Sprite", 1, 10);
    protected Beverage redbull = new Beverage("Redbull", 1, 10);
    protected Beverage monsterred = new Beverage("MonsterRed", 1, 10);
    protected Beverage pomegranate = new Beverage("Pomegranate Juice", 1, 10);
    protected Beverage oj = new Beverage("Orange Juice", 1, 10);
    protected Beverage carrot = new Beverage("Carrot Juice", 1, 10);
    protected Beverage propel = new Beverage("Propel", 1, 10);
    protected Beverage water = new Beverage("Water", 1, 10);

   // protected Beverage[] beverage = new Beverage[SIZE];
   //if we ever want a Beverage array to hold 10 pepsi's ....
    //then we can throw 10 arrays into a collection
    //->beverageMap.put(beverage[i];
    //not needed for the smallness of this proj

    //*Opens door, *begins loading

}
