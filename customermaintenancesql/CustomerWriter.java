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
public interface CustomerWriter
{
    boolean addCustomer(Customer c);
    boolean updateCustomer(Customer c);
    boolean deleteCustomer(Customer c);
    boolean disconnect();
    
   // boolean addCustomerInvoice(CustomerInvoice cInv);
}