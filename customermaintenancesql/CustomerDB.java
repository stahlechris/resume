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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author stahl
 */
public class CustomerDB implements CustomerDAO {

    private Connection getConnection() {
        Connection conn = null;
        try {
            String dbDirectory = "C:\\Users\\stahl\\Desktop\\ADVANCED_JAVA\\db";
            System.setProperty("derby.system.home", dbDirectory);

            String url = "jdbc:derby:CustomerDB";
            String username = "";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<CustomerInvoice> getCustomerInvoices() {
        String sql = "SELECT email, invoiceCode, invoiceDate, total "
                + "FROM Customer, Invoices "
                + "WHERE Customer.customerID = Invoices.customerID ORDER BY email";

        ArrayList<CustomerInvoice> customerInvoices = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String email = rs.getString("email");
                String invoiceCode = rs.getString("invoiceCode");
                String invoiceDate = rs.getString("invoiceDate");
                double total = rs.getDouble("total");

                CustomerInvoice cInv = new CustomerInvoice(email, invoiceCode, invoiceDate, total);
                customerInvoices.add(cInv);
            }
            return customerInvoices;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }

    }
//customerID INTEGER, email VARCHAR(40), firstName VARCHAR(25), lastName VARCHAR(25)

    public ArrayList<Customer> getCustomers() {
        String sql = "SELECT customerID, email, firstName, lastName "
                + "FROM Customer ORDER BY email ASC"; //auto ascendening already?

        ArrayList<Customer> customers = new ArrayList<>();
//customerID INTEGER, email VARCHAR(40), firstName VARCHAR(25), lastName VARCHAR(25));
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("customerID");
                String email = rs.getString("email");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                Customer c = new Customer(id, email, firstName, lastName);
                customers.add(c);
            }
            return customers;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }

    }

    public Customer getCustomer(String email) //email is the key
    {
        String sql
                = "SELECT customerID, email, firstName, lastName "
                + "FROM Customer "
                + "WHERE email = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("customerID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Customer c = new Customer(id, email, firstName, lastName);
                rs.close();
                return c;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public boolean addCustomer(Customer c) {
        String sql
                = "INSERT INTO Customer(customerID, email, firstName, lastName) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, c.getCustomerID());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getFirstName());
            ps.setString(4, c.getLastName());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }


    public boolean deleteCustomer(Customer c) {
        String sql
                = "DELETE FROM Customer "
                + "WHERE email = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean updateCustomer(Customer c) {
        String sql
                = "UPDATE Customer SET "
                + "firstName = ?, "
                + "lastName = ? "
                + "WHERE email = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.setString(1, c.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean disconnect() {
        try {
            String shutdownURL = "jdbc:derby:;shutdown=true";
            DriverManager.getConnection(shutdownURL);
            System.out.println("Unsuccesfully shutdown");
        } catch (SQLException e) {
            System.out.println("Successfully shutdown");
            if (e.getMessage().equals("Derby system shutdown.")) {
                return true;
            }
        }
        return false;
    }

}//end all 
