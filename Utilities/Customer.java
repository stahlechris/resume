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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer extends Validator {

    private String firstName;
    private String lastName;
    private String middleName;
    private String cardHolderName;
    private String cardNumber;
    private String creditCardType; //1 for visa, 2 for etc...
    private String expirationDate;
    private String cvv;

    Customer() {
        firstName = "";
        lastName = "";
        middleName = "";
        cardHolderName = "";
        cardNumber = "";
        creditCardType = "";
        expirationDate = "0/0";
        cvv = "";
    }



    /* IDK HOW TO DO THIS 
    public String makeCardHolderName(String cardHolderName, String lastName, String firstName,
            String middleName)
    {
        return cardHolderName = lastName + firstName + middleName;
    }
     */

    @Override
    public String toString() //this is super.toString() in other classes
    {
        return "Name: " + lastName + firstName + middleName + "\n"
                + "Credit Card Type: " + creditCardType + "\n"
                + "Credit Card Number: " + cardNumber + "\n"
                + "Expiration Date: " + expirationDate + "\n"
                + "CVV: " + cvv + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * @param cardHolderName the cardHolderName to set
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the creditCardType
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * @param creditCardType the creditCardType to set
     */
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    /**
     * @return the expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String makeCardType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
