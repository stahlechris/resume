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

public class CountUtil 
{
    //lets you count any Countable objects 
    public static void count (Countable c, int maxCount)
    {
        for (int i=0; i<maxCount;i++)
        {
            c.incrementCount(); //go to Alligator.java and do 
            c.getCount();       //go to Alligator.java and do
            
            System.out.println(c.getCountString());//Go to Alligator and do
        }
    }
    
}