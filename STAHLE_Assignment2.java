//***************************************************************************
//	File:                       LoanCalculator.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 2
//
//	Course Name:                Java Programming
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        September 6, 2016
//
//      Description:                This program calculates the monthly 
//                                  payments and years it will take to 
//                                  pay off a loan with interest.
//***************************************************************************
package loancalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator 
{
    public static double calculateMonthlyPayment(double loanAmt, int numYears,
            double yrIntrstRate) 
    {
        yrIntrstRate /= 100.0; //turn % to decimal
        int numMonths = numYears * 12; //num of months in X years
        double monthlyIntrstRate = yrIntrstRate / 12; //rate per month
        /*
        double monthlyPayment //calc principal
                = (loanAmt * monthlyIntrstRate)
                *  Math.pow( 1 + monthlyIntrstRate, numMonths)
                / (1 - Math.pow(1 + monthlyIntrstRate, numMonths) );
        this is how i first figured it out before looking at your formula
         */
        double monthlyPayment
                = loanAmt * monthlyIntrstRate
                / (1 - 1 / Math.pow(1 + monthlyIntrstRate, numMonths));
        //much smarter to add the numerator this way compared to mine!
        return monthlyPayment;
    }
///////////////////////////////////////////////////////////////////////////////
    public static double getLoanAmt(Scanner sc, double loanAmt) 
    {
        boolean isValid = false;
        while (!isValid) 
        {
            System.out.print("Enter loan amount:\t\t");

            if (sc.hasNextDouble()) //good they entered a double, drop down
            {
                loanAmt = sc.nextDouble();
                if (loanAmt < 0.0) 
                {
                    System.out.print("Error! Number must be "
                            + "greater than 0.0\n");
                } 
                else if (loanAmt > 999999.9) 
                {
                    System.out.print("Error! Number must be less "
                            + "than 1,000,000.0\n");
                } 
                else 
                {
                    isValid = true;
                    break;
                }
            } 
            else //scanner doesn't see a double
            {
                System.out.print("Error: Invalid decimal value. "
                        + "Try Again\n");
                sc.next();
            }

        } //end while IsValid  
        return loanAmt;
    }
///////////////////////////////////////////////////////////////////////////////
    public static double getYrIntrstRate(Scanner sc, double yrIntrstRate) 
    {
        boolean isValid2 = false;
        while (!isValid2) 
        {
            System.out.print("Enter yearly interest rate: \t");
            if (sc.hasNextDouble()) //good they entered a double, drop down
            {
                yrIntrstRate = sc.nextDouble();
                if (yrIntrstRate < 0.0) 
                {
                    System.out.print("Error! Number must be "
                            + "greater than 0.0\n");
                } 
                else if (yrIntrstRate > 19.9) 
                {
                    System.out.print("Error! Number must be less "
                            + "than 20%\n");
                } 
                else 
                {
                    isValid2 = true;
                    break;
                }
            } 
            else //scanner doesn't see a double
            {
                System.out.print("Error: Invalid decimal value."
                        + "Try Again\n");
                sc.next();
            }
        } //end 2nd while
        return yrIntrstRate;
    }
/////////////////////////////////////////////////////////////////////////////
    public static int getNumYears(Scanner sc, int numYears) 
    {
        boolean isValid3 = false;
        while (!isValid3) 
        {
            System.out.print("Enter number of years: \t\t");
            if (sc.hasNextInt()) //good they entered a double, drop down
            {
                numYears = sc.nextInt();
                if (numYears < 0) 
                {
                    System.out.print("Error! Number must be "
                            + "greater than 0\n");
                } 
                else if (numYears > 99) 
                {
                    System.out.print("Error! Number must be less "
                            + "than 100\n");
                } 
                else 
                {
                    isValid3 = true;
                    break;
                }
            }
            else //scanner doesn't see a double
            {
                System.out.print("Error: Invalid integer value."
                        + "Try Again\n");
                sc.next();
            }
        }
        return numYears;
    }
///////////////////////////////////////////////////////////////////////////////  
    public static void displayFormattedResults(double updatedLoanAmt,
    double updatedYrIntrstRate, int updatedNumYears, double monthlyPayment) 
    {
        System.out.print("FORMATTED RESULTS\n\n");
        System.out.print("Loan amount:      \t");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.print(currency.format(updatedLoanAmt) + "\n");

        System.out.print("Yearly interest rate:   ");
        System.out.print(updatedYrIntrstRate + "%\n");

        System.out.print("Number of years:\t");
        System.out.print(updatedNumYears + "\n");

        System.out.print("Monthly payment: \t");
        System.out.print(currency.format(monthlyPayment)+"\n");
    }
///////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String userChoice = "y";
        System.out.print("Welcome to the Loan Calculator\n\n");
        System.out.print("DATA ENTRY\n");
        double loanAmt = 0.0;
        double yrIntrstRate = 0.0;
        int numYears = 0;
        while (userChoice.equalsIgnoreCase("y")) 
        {
            double updatedLoanAmt = getLoanAmt(sc, loanAmt);
            /*^It's very weird to me that you can't pass by reference to update
              mains' value! I am used to easily doing this by using & symbol.
             */
            double updatedYrIntrstRate = getYrIntrstRate(sc, yrIntrstRate);
            int updatedNumYears = getNumYears(sc, numYears);
            double monthlyPayment = calculateMonthlyPayment(updatedLoanAmt,
                    updatedNumYears, updatedYrIntrstRate);
            displayFormattedResults(updatedLoanAmt, updatedYrIntrstRate,
                    updatedNumYears, monthlyPayment);

            System.out.print("Continue? (y/n):");
            userChoice = sc.next();
            System.out.println();

            while (!userChoice.equalsIgnoreCase("y")
                && !userChoice.equalsIgnoreCase("n")) 
            {
                System.out.print("Error! Entry must be 'y' or 'n'. "
                        + "Try again\n");
                userChoice = sc.next();
            }
        }//userChoice while //fixed curly bracer after this loop 9/6/2016
    } //main
} //pckg500