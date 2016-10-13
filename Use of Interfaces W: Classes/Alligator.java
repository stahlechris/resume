//***************************************************************************
//	File:                       CountTestApp.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 5
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        September 27, 2016
//
//      Description:                This program uses interfaces and classes
//                                  to display and clone objects 
//***************************************************************************

package counttestapp;

public class Alligator implements Countable 
{
    //"instance variable that stores the count 
    private int count = 0;
    
    @Override
    public void incrementCount() 
    {
        count++;    
    }
    
    //overrides the Countable interface method    
    @Override
    public void resetCount() 
    {
        count = 0;    
    }
    
    //overrides the Countable interface method
    @Override 
    public int getCount() 
    {
        return count;
    }
    
    //method returns the formatted count
    @Override
    public String getCountString() 
    {
        return count + " " + "Alligator";
    }   
}