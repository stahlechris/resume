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

public class Customer {

    private int customerID;
    private String email;
    private String firstName;
    private String lastName;

    //constructor
    public Customer() {
        customerID = 0;
        email = "";
        firstName = "";
        lastName = "";
    }

    //overloaded constructor
    public Customer(int id, String email, String firstName, String lastName) {
        this.customerID = id; //be careful...
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
@Override
public String toString()
{
    return email + "->" + customerID;
}
    public int getCustomerID() {
        return customerID;
    }
    
    public void setCustomerID(int id) //not recomended to set primary key, let auto generate
    {
        this.customerID = id;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstName
     */
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

    public String getName() {
        return firstName + " " + lastName;
    }

}
