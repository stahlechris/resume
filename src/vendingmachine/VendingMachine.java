//***************************************************************************
//	File:                       VendingMachine.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # Extra Credit Week 2
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        November 8, 2016
//
//      Description:                This program simulates a vending machine
//                                   
//***************************************************************************
package vendingmachine;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class VendingMachine {

    //A VendingMachine has a name - the fist machine starts at 1 ...[0]
    private static final int VENDING_MACHINE_IDENTIFIER_NUMBER = 1;
    //A VendingMachine needs to be loaded by someone
    VendingMachineLoader load = new VendingMachineLoader();
    //The VendingMachine will ALWAYS only be able to hold 10 different types of beverage
    private static final int SIZE = 10;
    private int totalNumberOfBeveragesLeft;
    //A VendingMachine holds a collection of beverages...
    //private LinkedListImplementationOfAStack<Beverage> inventory = new LinkedListImplementationOfAStack<>();

    //A VendingMachine holds a collection of beverages...
    public Map<String, Beverage> beverageMap = new HashMap<String, Beverage>();

    //A VendingMachine keeps track of how much money it has in it
    //private double credits;       /* DEPRECATED FOR THE CASHREGISTER CLASS 
    //private int numDollars;
    //private int numQuarters;
    //Initialize the machine with 10 of each Beverage
    VendingMachine() {
        beverageMap.put(load.pepsi.getType(), load.pepsi);
        beverageMap.put(load.coke.getType(), load.coke);
        beverageMap.put(load.sprite.getType(), load.sprite);
        beverageMap.put(load.redbull.getType(), load.redbull);
        beverageMap.put(load.monsterred.getType(), load.monsterred);
        beverageMap.put(load.pomegranate.getType(), load.pomegranate);
        beverageMap.put(load.oj.getType(), load.oj);
        beverageMap.put(load.carrot.getType(), load.carrot);
        beverageMap.put(load.propel.getType(), load.propel);
        beverageMap.put(load.water.getType(), load.water);
        /*
        inventory.push(load.pepsi);
        inventory.push(load.coke);
        inventory.push(load.sprite);
        inventory.push(load.redbull);   //DEPRECATED IN FAVOR OF HASHMAP!
        inventory.push(load.monsterred);
        inventory.push(load.pomegranate);
        inventory.push(load.oj);
        inventory.push(load.carrot);
        inventory.push(load.propel);
        inventory.push(load.water);
         */
        //!sout = LIFO DT!
        totalNumberOfBeveragesLeft = 100;
        //credits = 0.0;
        //numDollars = 0;
        //numQuarters = 0;
        System.out.println("Heres the hasmap ");
        {
            for (Map.Entry<String, Beverage> e : beverageMap.entrySet()) {
                System.out.println("Key : " + e.getKey() + " found " + e.getValue());
            }
        }
    }

    /*    /* DEPRECATED FOR THE CASHREGISTER CLASS 
    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits += credits;
    }
     */
    //A VendingMachine always keeps track of it's totalNumberOfBeverages
    public int getNumberOfBeveragesLeft() {
        //if() dispense() returns an object, totalNumberOfBeveragesLeft--;
        return totalNumberOfBeveragesLeft;
    }

    public void setTotalNumberOfBeveragesLeft(int totalNumberOfBeveragesLeft) {
        this.totalNumberOfBeveragesLeft = totalNumberOfBeveragesLeft;
    }

    //A VendingMachine can call someone to restock it..if<= 500 beverages , call this method.
    public void restock() { //WHEN DO I CALL THIS???? CAN'T BE AFTER EVERY PURCHASE FOR SURE
        if (totalNumberOfBeveragesLeft < 50) {
            System.out.println("I need to be restocked!");
            JOptionPane optionPane = new JOptionPane("I need to be restocked!", JOptionPane.WARNING_MESSAGE);
            //end program... for now...=)
        }
    }
    /* DEPRECATED FOR THE CASHREGISTER CLASS 
    public void setNumQuarters(int numQuarters) {

        this.numQuarters += numQuarters;

    }

    public int getNumQuarters() {
        return numQuarters;
    }

    public void setNumDollars(int numDollars) {
        this.numDollars += numDollars;
    }

    public int getNumDollars() {
        return numDollars;
    }
     */

}
