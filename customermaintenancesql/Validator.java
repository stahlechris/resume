//***************************************************************************
//	File:                       CustomerMaintApp.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 6
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        December 6, 2016
//
//      Description:                This program maintains a list of customers.
//                                  It reads and writes from and to a 
//                                  derby database.
//***************************************************************************
package customermaintenancesql;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    /*
    public static String getLine(Scanner sc, String prompt) {
        sc.nextLine();//clear //this method is worthless for my case
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();//clear
        return s;
    }

    public static String getUserChoice(Scanner sc, String menu, String error) {
        String validatedChoice = "";
        String validatedToUpper = ""; //strings are immutable in java *sigh*
        boolean isValid = false;
        while (!isValid) {
            System.out.print(menu);
            validatedChoice = sc.next(); //no spaces
            if (validatedChoice.equalsIgnoreCase("list_customers")
                    || validatedChoice.equalsIgnoreCase("list_customer_invoices")
                    || validatedChoice.equalsIgnoreCase("list")
                    || validatedChoice.equalsIgnoreCase("add")
                    || validatedChoice.equalsIgnoreCase("add_customer_invoice")
                    || validatedChoice.equalsIgnoreCase("del")
                    || validatedChoice.equalsIgnoreCase("help")
                    || validatedChoice.equalsIgnoreCase("update")
                    || validatedChoice.equalsIgnoreCase("exit")) {
                isValid = true;
                validatedToUpper = validatedChoice.toUpperCase();
            } else {
                System.out.println(error);
            }
        }
        return validatedToUpper;
    }

    public static String validateEmail(Scanner sc, String prompt) {
        boolean isValid = false;
        String validatedEmail = "";
        String EMAIL_REGIX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]{0,10})"
                + "*@[A-Za-z0-9]+(\\.[A-Za-z0-9]{0,10})*(\\.[A-Za-z]{0,5})$";
        Pattern pattern = Pattern.compile(EMAIL_REGIX);
        while (!isValid) {
            System.out.print(prompt);
            validatedEmail = sc.next();
            Matcher matcher = pattern.matcher(validatedEmail);
            if (matcher.matches()) {
                isValid = true;
            } else {
                System.out.println("Invalid Email address\n");
            }
        }
        return validatedEmail;
    }

    public static String validateInvoiceNumber(Scanner sc, String prompt) {
        boolean isValid = false;
        String validatedInvoiceNumber = "";
        String INVOICE_NUMBER_REGEX = "\\d{5}[A-Z]"; //5 digits, any caps Letter
        Pattern pattern = Pattern.compile(INVOICE_NUMBER_REGEX);
        while (!isValid) {
            System.out.print(prompt);
            validatedInvoiceNumber = sc.next();
            Matcher matcher = pattern.matcher(validatedInvoiceNumber);
            if (matcher.matches()) {
                isValid = true;
            } else {
                System.out.println("Invalid Invoice Number\n");
            }
        }
        return validatedInvoiceNumber;
    }

}//end all
