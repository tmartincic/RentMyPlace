package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the Contact table
 */
public class Contact extends Model
{
    //attributes
    private static final String table_name = "contact";

    public int id;
    public String fullName;
    public String email;
    public int phone;
    public int locationId;

    //default constructor
    public Contact() {
        super(table_name);
        this.id = -1;
        this.fullName = null;
        this.email = null;
        this.phone = -1;
        this.locationId = -1;
    }

    //parametrized constructor
    public Contact(int id, String fullName, String email, int phone, int locationId) {
        super(table_name);
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationId = locationId;
    }

    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    @Override
    public String toString() {
        return "edu.rit.iste330.team7.RentMyPlace.model.Contact{" +
                "id=" + id +
                ", fullName=" + fullName + '\'' +
                ", email=" + email + '\'' +
                ", phone=" + phone +
                ", locationId=" + locationId +
                '}';
    }

    /**
     * Assignes new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return Contact
     */
    public Contact assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "fullName" -> this.setFullName(row.get(attribute));
                case "email" -> this.setEmail(row.get(attribute));
                case "phone" -> this.setPhone(Integer.parseInt(row.get(attribute)));
                case "locationId" -> this.setLocationId(Integer.parseInt(row.get(attribute)));
            }
        }
        return this;
    }

    /**
     * Gets Contact table data
     * @return ArrayList<Contact>
     */
    @Override
    public ArrayList<Contact> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Contact> contacts = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Contact contact = new Contact();
            contact.assign(row);
            contacts.add(contact);
        }
        return contacts;
    }

    /**
     * Creates an new instance of Contact
     * @param row Map<String, String>
     * @return Contact
     */
    public Contact create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Contact table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Contact
     */
    public Contact update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Contact instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Contact
     */
    public Contact delete(){
        super.deleteModel(this.id);
        return this;
    }
}