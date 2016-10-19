package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {

    public boolean isPresent(JTextComponent c, String fieldName) {
        if (c.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, fieldName + "is a required field!",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent c, String fieldName)//in case they copy paste 
    {
        try {
            int i = Integer.parseInt(c.getText());
            return true;              
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, fieldName + "needs to contain numbers only!",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            c.requestFocusInWindow();
            return false;
        }

    }

    public void autoGenerateHyphonsForCreditcardNumber() {
        //generates hyphons for readability when entering card number

    }

    public void autoGenerateSlashForExpirationDate() {
        //automatically puts a slash
    }
    
    public boolean hasFifteenOrSixteenDigits(JTextComponent c, String fieldName)
    {
        String cardNumber = c.getText();
        if( cardNumber.length() == 15 || cardNumber.length() == 16)
            return true; return false; 
    }

    public String isValidCreditCardNum(JTextComponent c, String fieldName) 
    {
        String cardNumber = c.getText();
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
        else if(discoverMatcher.matches())
        {
            creditCardType = "Discover";
        }
        else
            creditCardType = "";
        return creditCardType;
    }

    public boolean isValidName() {
        //"enter name exactly how it appears on card
        //checks if name is valid ---simple check
        return true;
    }
    
    public boolean isEveryFieldFilled()
    {
        //checks if every field is filled, so we can validate them all 
    }
    
    public boolean customersCreditExists()
    {
        //takes the num, exp date, name, and cvv and checks them against our DB
    }

    

} //end class 
