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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter.Entry;

public class VendingMachine {

    //A VendingMachine has a name - the fist machine starts at 1 ...[0]
    private static final int VENDING_MACHINE_IDENTIFIER_NUMBER = 1;
    //A VendingMachine needs to be loaded by someone
    VendingMachineLoader load = new VendingMachineLoader();
    //The VendingMachine will ALWAYS only be able to hold 10 different types of beverage
    private static final int SIZE = 10;
    private int totalNumberOfBeveragesLeft;
    //A VendingMachine holds a collection of beverages...it knows how many there are of each
    private LinkedListImplementationOfAStack<Beverage> inventory = new LinkedListImplementationOfAStack<>();

    //Everybody can see how many Beverages there are in the VendingMachine...
    public Map<String, Beverage> beverageMap = new HashMap<String, Beverage>();

    //A VendingMachine keeps track of how much money it has in it
    private double credits;
    private int numDollars;
    private int numQuarters;

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

        inventory.push(load.pepsi);
        inventory.push(load.coke);
        inventory.push(load.sprite);
        inventory.push(load.redbull);
        inventory.push(load.monsterred);
        inventory.push(load.pomegranate);
        inventory.push(load.oj);
        inventory.push(load.carrot);
        inventory.push(load.propel);
        inventory.push(load.water);
        //!sout = LIFO DT!
        totalNumberOfBeveragesLeft = 100;
        credits = 0.0;
        numDollars = 0;
        numQuarters = 0;
        System.out.println("Heres the hasmap ");
        {
            for (Map.Entry<String, Beverage> e : beverageMap.entrySet()) {
                System.out.println("Key : " + e.getKey() + " found " + e.getValue());
            }
        }
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {

        this.credits += credits;

    }

    public Beverage dispense() { //this returns the String name of the item
        return inventory.pop();
    }

    //A VendingMachine always keeps track of it's totalNumberOfBeverages
    public int getNumberOfBeveragesLeft() {
        //if() dispense() returns an object, totalNumberOfBeveragesLeft--;
        return totalNumberOfBeveragesLeft;
    }

    public void setTotalNumberOfBeveragesLeft(int totalNumberOfBeveragesLeft) {
        this.totalNumberOfBeveragesLeft = totalNumberOfBeveragesLeft;
    }

    //A VendingMachine can call someone to restock it..if<= 500 beverages , call this method.
    public void restock() {
        if (totalNumberOfBeveragesLeft < 51) {
            System.out.println("I need to be restocked!");
            //call the loader
        }

    }

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

}
