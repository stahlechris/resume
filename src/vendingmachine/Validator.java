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

import java.util.Map;

public class Validator {
    
    public boolean checkCredit(double currentCredit)
    {
        boolean isGood = false;
        if(currentCredit >= 1)
            isGood = true;
        else
            isGood = false;
        return isGood;
    }
}
