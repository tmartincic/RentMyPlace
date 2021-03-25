import java.sql.Date;

public class Billing implements Model {
    public int id;
    public String billingAddress;
    public String creditCardNum;
    public String CVC;
    public java.sql.Date expireDate;
    public String ownerName;

    @Override
    public Billing findModelById(int id) {
        //JDBC SELECT from table WHERE ID = id;
        return this;
    }

    public Billing() {
        this.id = -1;
        this.billingAddress = null;
        this.creditCardNum = null;
        this.CVC = null;
        this.expireDate = null;
        this.ownerName = null;
    }

    public Billing(int id, String billingAddress, String creditCardNum, String CVC, Date expireDate, String ownerName) {
        this.id = id;
        this.billingAddress = billingAddress;
        this.creditCardNum = creditCardNum;
        this.CVC = CVC;
        this.expireDate = expireDate;
        this.ownerName = ownerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}