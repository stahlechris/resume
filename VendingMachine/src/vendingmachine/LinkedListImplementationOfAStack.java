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

import java.util.LinkedList;
import java.util.Stack;

public class LinkedListImplementationOfAStack<DT> {
    
    private LinkedList<DT> list = new LinkedList<>();//linkedList that will hold the elements
    //then use linkedList to imlement the methods of Stack
    public void push(DT item)
    {
        list.addLast(item);
    }
    public DT pop() 
    { 
        return list.removeLast(); 
    }
    public DT peek()
    { 
        return list.getLast();
    }
    public int size()
    {
        return list.size();
    }
    public DT print()
    {
        return list.getLast();
    }
    
}
   