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

public class Beverage 
{
    private String type; //dr pepper
    private int cost; //$1.00 aka "1"
    private int quantity; //10/10 dr.peppers remaining

    Beverage()
    {
        type = "";
        cost = 1;
        quantity = 10;
    }
    Beverage(String s, int c, int q)
    {
        type = s;
        cost = c;
        quantity = q;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    @Override
    public String toString()
    {
        return type +", "+ quantity ;
    }
}
