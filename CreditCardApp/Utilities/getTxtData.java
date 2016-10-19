//***************************************************************************
//	File:                       getTxtData.Java
//
//	Student:                    Chris Stahle
//
//
//      Description:                This class simulates reading data from a server
//                                  by reading a .txt file with CC information.
//                                  Other classes use this cleaned data to validate
//                                  they have the right information entered. 
//***************************************************************************
package Utilities;
//import Utilities.Customer;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getTxtData //might as well be a main[]
{
    String updatedCardNumberNoHyphons = "";
    public String updatedCreditCardType = "";
    private static final String COMMADELIMITER = ", ";//comma and a space
    private static final String DASHDELIMITER = "-";
    private int length = 0; //how mny lines r in the file 
    private List customers = new ArrayList();
    
    public void loadData() 
    {
//copys below function to get how mny lines r in the file to set the array size 
        try (FileReader reader = new FileReader("src/Resources/CreditCardInformation.txt");
                BufferedReader br = new BufferedReader(reader)) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] commaTokens = line.split(COMMADELIMITER);
                if(commaTokens.length >= 0)
                {
                   Customer c = new Customer();
                   c.setLastName(commaTokens[0]);
                   c.setFirstName(commaTokens[1]);
                   c.setMiddleName(commaTokens[2]);
                   c.setCardNumber(commaTokens[3]);
                   c.setExpirationDate(commaTokens[4]);
                   c.setCvv(commaTokens[5]);
                   //remove hyphons so we can get the type of CC
                   updatedCardNumberNoHyphons = removeHyphonsFromCardNumber(c.getCardNumber());
                   //use updated CC num without hyphons to get CC type 
                   updatedCreditCardType = makeCreditCardType(updatedCardNumberNoHyphons);
                   c.setCreditCardType(updatedCreditCardType);
                   customers.add(c);
                   System.out.print(c);
                  // break; //arrayGoesOutOfBounds 
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }


public static String getRidOfArrayListBrackets(String s) //must invoke list. or hash.toString to use 
{
    String st =""; //gets rid of arrayList [ , ] bullshit 
    
    st = s.replaceAll(",", "");
    st = st.replaceAll("\\[", "");
    st = st.replaceAll("\\]", "");
    st = st.replaceAll(" ", "");
    return st;
}
    public String removeHyphonsFromCardNumber(String cardNumber)
    {
        return cardNumber = cardNumber.replaceAll("-", "");
    }
    public String makeCreditCardType(String cardNumber) 
    {
        String creditCardType = "";
        Pattern visaPattern = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
        Matcher visaMatcher = visaPattern.matcher(cardNumber);
        //////////////////////////////////////////////////////////////////
        Pattern masterCardPattern = Pattern.compile("^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$");
        Matcher masterCardMatcher = masterCardPattern.matcher(cardNumber);
        //////////////////////////////////////////////////////////////////
        Pattern amexPattern = Pattern.compile(" ^3[47][0-9]{13}$");
        Matcher amexMatcher = amexPattern.matcher(cardNumber);
        /////////////////////////////////////////////////////////////////
        Pattern discoverPattern = Pattern.compile("^6(?:011|5[0-9]{2})[0-9]{12}$");
        Matcher discoverMatcher = discoverPattern.matcher(cardNumber);
        ////////////////////////////////////////////////////////////////
        if (visaMatcher.matches()) 
        {
            creditCardType = "Visa";
        }
        else if(masterCardMatcher.matches() )
        {
            creditCardType = "MasterCard";
        }
        else if(amexMatcher.matches())
        {
            creditCardType = "American Express";
        }
        else
        {
            creditCardType = "Discover";
        }
        return creditCardType;
    }

} //end class 
