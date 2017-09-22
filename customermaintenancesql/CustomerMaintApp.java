
//      Description:                This program maintains a list of customers.
//                                  It reads and writes from and to a 
//                                  derby database.
//***************************************************************************
package customermaintenancesql;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class CustomerMaintApp implements CustomerConstants {

    private static CustomerDAO customerDAO = null;
    private static Scanner sc = null;

    public static void main(String[] args) {
        System.out.println("Welcome to the Customer Maintenance application\n");
        customerDAO = DAOFactory.getCustomerDAO();
        sc = new Scanner(System.in);

        displayMenu();

        String userChoice = "";
        //The Java compiler generates generally more efficient bytecode from switch statements 
        //that use String objects than from chained if-then-else statements.
        //VIA https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html
        while (!userChoice.equalsIgnoreCase("exit")) {
            userChoice = Validator.getUserChoice(sc, "Enter a command: ", "Invalid choice");
            System.out.println();

            switch (userChoice) {
                case "LIST_CUSTOMERS":
                    displayAllCustomers();
                    break;
                case "LIST_CUSTOMER_INVOICES":
                    displayAllCustomerInvoices();
                    break;
                case "ADD":
                    addCustomer();
                    break;
                /*
                case "ADD_CUSTOMER_INVOICE":
                    addCustomerInvoice();
                    break;
                 */
                case "DEL":
                    deleteCustomer();
                    break;
                case "HELP":
                    displayMenu();
                    break;
                case "UPDATE":
                    updateCustomer();
                    break;
                case "EXIT":
                    System.out.println("Disconnecting from DB and exiting...");
                    customerDAO.disconnect();
                    break;
                default:
                    System.out.println("Disconnecting from DB and exiting...");
                    customerDAO.disconnect();
                    System.exit(0);
            }
        }

    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU\n list_customers    - List all customers\n "
                + "list_customer_invoices    - List Invoices of Customers\n "
                + "add     - Add a customer\n "
                + "del     - Delete a customer\n help    - Show this menu\n"
                + " update  - Update a customer\n exit    - Exit this application\n");
    }

    public static void displayAllCustomers() {
        System.out.println("CUSTOMER LIST\nEMAIL\t\t\t   FIRSTNAME\t\t      LASTNAME");

        ArrayList<Customer> customers = customerDAO.getCustomers();
        Customer c = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            c = customers.get(i); //index of customer email//firstname//lastname
            sb.append(StringUtils.addSpaces(c.getEmail(), NAME_SIZE + 2));
            sb.append(StringUtils.addSpaces(c.getFirstName(), NAME_SIZE + 2));
            sb.append(StringUtils.addSpaces(c.getLastName(), NAME_SIZE + 2));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void displayAllCustomerInvoices() {
        ArrayList<CustomerInvoice> customerInvoices = customerDAO.getCustomerInvoices();//gathers succesfully
        CustomerInvoice cInv = null;
        StringBuilder sb = new StringBuilder();
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        for (int i = 0; i < customerInvoices.size(); i++) {
            cInv = customerInvoices.get(i); //index of object to have values extracted / manipulated
            sb.append(StringUtils.addSpaces(cInv.getEmail(), NAME_SIZE + 2));
            sb.append(StringUtils.addSpaces(cInv.getInvoiceCode(), INVOICE_CODE_SIZE + 2));
            sb.append(StringUtils.addSpaces(cInv.getInvoiceDate(), DATE_SIZE + 2));
            sb.append(defaultFormat.format(cInv.getInvoiceTotal()));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addCustomer() {
        String email = Validator.validateEmail(sc, "Enter customer email: ");

        Customer c = customerDAO.getCustomer(email);//check if already exists
        if (c != null) { //if email exists...
            System.out.println("You can't add the same customer twice!");
        } else {
            String firstName = Validator.getString(
                    sc, "Enter first name: ");
            String lastName = Validator.getString(
                    sc, "Enter last name: ");

            Customer customer = new Customer();
            //get highestCustomerID to increment for additional customers primary key
            ArrayList<Customer> customers = customerDAO.getCustomers();
            Customer highestIdCustomer = customers.get(0); //these are pre-sorted by SQL when they come in
            int max = highestIdCustomer.getCustomerID(); //max is first entry's id
            for (Customer check : customers) {
                System.out.println("nth customer in arraylist is : " + check.toString());
                if (max > check.getCustomerID()) {
                    continue;
                } else {
                    max = check.getCustomerID();
                    System.out.println("The Old highest ID was -> " + max);
                    System.out.println("Additional customer will receive id of -> " + ++max);
                }
            }
            customer.setCustomerID(++max); //customerId is 1 higher than the highest now
            customer.setEmail(email);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customerDAO.addCustomer(customer);

            System.out.println();
            System.out.println(firstName + " " + lastName + " has been added.\n");
        }
    }

    public static void updateCustomer() {
        String emailToBeUpdated = Validator.getString(sc, "Enter email of customer to update: ");

        Customer c = customerDAO.getCustomer(emailToBeUpdated);//here's who we want to replace
        System.out.println();

        if (c != null) { //if email exists...
            System.out.println("We found that customer.");
            int oldID = c.getCustomerID(); //hang on to their ID
            System.out.println("old id was -> " + oldID);
            customerDAO.deleteCustomer(c);

            //gather replacement info
            String firstName = Validator.getString(
                    sc, "Enter a replacement first name: ");
            String lastName = Validator.getString(
                    sc, "Enter a replacement last name: ");
            Customer updatedCustomer = new Customer(); //has ID of 0
            //updatedCustomer needs to keep same ID
            updatedCustomer.setCustomerID(oldID); //has id of oldID
            updatedCustomer.setEmail(emailToBeUpdated);
            updatedCustomer.setFirstName(firstName);
            updatedCustomer.setLastName(lastName);
            customerDAO.addCustomer(updatedCustomer);
            customerDAO.updateCustomer(updatedCustomer); //send customer tied to entered email
            System.out.println(c.getName() + " has been updated to " + firstName + " " + lastName + ".\n");
        } else {
            System.out.println("No customer matches that email. Can't update.\n");
        }
    }

    public static void deleteCustomer() { //invoices are lost if customer is deleted!
        String email = Validator.getString(sc, "Enter email to delete: ");

        Customer c = customerDAO.getCustomer(email);
        System.out.println();
        if (c != null) {
            customerDAO.deleteCustomer(c);
            System.out.println(c.getName() + " has been deleted.\n");

        } else {
            System.out.println("No customer matches that email.\n");
        }
    }
}
