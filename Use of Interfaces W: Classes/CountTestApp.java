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

public class CountTestApp extends CountUtil 
{
    
    public static void main(String agrs[]) throws CloneNotSupportedException
    {
        System.out.println("Counting alligators..." + "\n");
        //Interface gets a new Alligator object..
        Countable a = new Alligator();    
        //count it 3 times in CountUtil.java...
        count(a,3); //"1 alligator
        
        System.out.println("\nCounting sheep..." + "\n");
        //Interface gets a new sheep object...
        Countable s = new Sheep();
        //make a new sheep object 
        Sheep s1 = new Sheep();
        
        s1.setSheepName("Blackie");        
        //counts the first sheep two times
        count(s1,2);//Blackie + count \nBlackie + count 
        
        System.out.println();
        
        //based on a Sheep object, clone our first sheep and give to sheep2
        Sheep s2 = (Sheep) s1.clone();
        //resets the count to 0 for sheep2 
        s2.resetCount();
        //changes and sets the sheep name to "Dolly"
        s2.setSheepName("Dolly");
        //counts the second sheep three times
        count(s2,3);
        
        System.out.println();
        
        //resets the first sheep object count to 0
        s1.resetCount();
        //sets first sheep object name to "Blackie"
        s1.setSheepName("Blackie");        
        //counts the first sheep object one time
        count(s1,1);
    }
    
}