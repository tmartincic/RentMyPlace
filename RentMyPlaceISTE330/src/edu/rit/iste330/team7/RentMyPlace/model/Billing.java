package edu.rit.iste330.team7.RentMyPlace.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Billing extends Model {

    private static final String table_name="billing";

    public int id;
    public String billingAddress;
    public String creditCardNum;
    public String CVC;
    public java.sql.Date expireDate;
    public String ownerName;


    public Billing() {
        super(table_name);
        this.id = -1;
        this.billingAddress = null;
        this.creditCardNum = null;
        this.CVC = null;
        this.expireDate = null;
        this.ownerName = null;
    }

    public Billing(int id, String billingAddress, String creditCardNum, String CVC, Date expireDate, String ownerName) {
        super(table_name);
        this.id = id;
        this.billingAddress = billingAddress;
        this.creditCardNum = creditCardNum;
        this.CVC = CVC;
        this.expireDate = expireDate;
        this.ownerName = ownerName;
    }

    @Override
    public String toString(){
        return "edu.rit.iste330.team7.RentMyPlace.model.Favorite{" +
                "id=" + id +
                ", billingAddress='" + billingAddress + '\'' +
                ", creditCardNum=" + creditCardNum +
                ", CVC=" + CVC +
                ", expireDate=" + expireDate +
                ", ownerName='" + ownerName + '\'' +
                '}';
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

    public Billing assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "billingAddress" -> this.setBillingAddress(row.get(attribute));
                case "creditCardNum" -> this.setCreditCardNum(row.get(attribute));
                case "CVC" -> this.setCVC(row.get(attribute));
                case "expireDate" -> this.setExpireDate(Date.valueOf(row.get(attribute)));
                case "ownerName" -> this.setOwnerName(row.get(attribute));
            }
        }
        return this;
    }

    @Override
    public ArrayList<Billing> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Billing> billings = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Billing billing = new Billing();
            billing.assign(row);
            billings.add(billing);
        }
        return billings;
    }

    public Billing create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Billing table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Billing
     */
    public Billing update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Billing instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Billing
     */
    public Billing delete(){
        super.deleteModel(this.id);
        return this;
    }
}