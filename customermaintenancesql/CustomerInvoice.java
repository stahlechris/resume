
package customermaintenancesql;

/**
 *
 * @author stahl
 */
public class CustomerInvoice {
    private String email;
    private String invoiceCode;
    private String invoiceDate;
    private double invoiceTotal;

    CustomerInvoice(String email,String invoiceCode, String invoiceDate, double invoiceTotal)
    {
        this.email = email;
        this.invoiceCode = invoiceCode;
        this.invoiceDate = invoiceDate;
        this.invoiceTotal = invoiceTotal;
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
     * @return the invoiceCode
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * @param invoiceCode the invoiceCode to set
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    /**
     * @return the invoiceDate
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * @param invoiceDate the invoiceDate to set
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * @return the invoiceTotal
     */
    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    /**
     * @param invoiceTotal the invoiceTotal to set
     */
    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
    
}
