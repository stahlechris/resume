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

public class Sheep implements Countable, Cloneable 
{
    
    //instance variables that store the count 
    //and the name of the sheep
    private int countSheep = 0;
    private String sheepName = "";

    public void setSheepName(String s)
    {
        sheepName = s;
    }
    
    public String getSheepNames()
    {
        return sheepName;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    //method increments count of sheep +1
    @Override 
    public void incrementCount() 
    {
        countSheep = countSheep +1;
    }
    
    //method resets the count to 0
    @Override
    public void resetCount()
    {
        countSheep = 0;
    }
    
    @Override
    public int getCount()
    {
        return countSheep;    
    }
    //return formatted count
    @Override
    public String getCountString()
    {
        return getCount() + " " + getSheepNames();    //add space
    }
    
}