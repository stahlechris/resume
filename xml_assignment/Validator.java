//***************************************************************************
//	File:                       MusicArtistsApp.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # 4
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        November 22, 2016
//
//      Description:                This program reads an XML file to display
//                                  a list of artists and listings.
//***************************************************************************
package xml_assignment;

import java.util.Scanner;

public class Validator {

    public static String getUserChoice(Scanner sc, String menu, String error) {
        String validatedChoice = "";
        String validatedToUpper = ""; //strings are immutable in java *sigh*
        boolean isValid = false;
        while (!isValid) {
            System.out.print(menu);
            validatedChoice = sc.next(); //no spaces
            if (validatedChoice.equalsIgnoreCase("list")
                    || validatedChoice.equalsIgnoreCase("add")
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

}//end all
