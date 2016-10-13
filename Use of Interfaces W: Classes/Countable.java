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

public interface Countable 
{
    void incrementCount();
    void resetCount();
    int getCount();
    String getCountString();
}
//done 