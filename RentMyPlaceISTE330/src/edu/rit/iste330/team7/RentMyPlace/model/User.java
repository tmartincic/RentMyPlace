package edu.rit.iste330.team7.RentMyPlace.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import edu.rit.iste330.team7.RentMyPlace.controller.Authentication;

public class User extends Model
{
    private static final String table_name = "user";

    private int id;
    private String username;
    private String password;
    private String userType;
    private int contactId;
    private int billingId;
    private String token;

    public User() {
        super(table_name);
        this.id = -1;
        this.username = null;
        this.password = null;
        this.userType = null;
        this.contactId = -1;
        this.billingId = -1;
        this.token = null;
    }

    public User(int id, String username, String password, String userType, int contactId, int billingId) {
        super(table_name);
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.contactId = contactId;
        this.billingId = billingId;
        this.token = null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    @Override
    public String toString() {
        return "edu.rit.iste330.team7.RentMyPlace.model.User{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", userType=" + userType +
                ", contactId=" + contactId +
                ", billingId=" + billingId +
                '}';
    }

    public User assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "username" -> this.setUsername(row.get(attribute));
                case "password" -> this.setPassword(row.get(attribute));
                case "userType" -> this.setUserType(row.get(attribute));
                case "contactId" -> this.setContactId(Integer.parseInt(row.get(attribute)));
                case "billingId" -> this.setBillingId(Integer.parseInt(row.get(attribute)));
                case "token" -> this.setToken(row.get(attribute));
            }
        }
        return this;
    }
    @Override
    public ArrayList<User> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<User> users = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            User user = new User();
            user.assign(row);
            users.add(user);
        }
        return users;
    }

    public User create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.User table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.User
     */
    public User update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.User instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.User
     */
    public User delete(){
        super.deleteModel(this.id);
        return this;
    }

    public boolean authenticate(String givenUsername, String givenPassword){
        User user = (User) this.where("username", "like", givenUsername).get().get(0);
        if(user == null) return false;

        String convertedPassword = Authentication.convert(givenPassword);
        if(user.getPassword().equals(convertedPassword)){
            setId(user.getId());
            setUsername(user.getUsername());
            setPassword(user.getPassword());
            setContactId(user.getContactId());
            setBillingId(user.getBillingId());
            setUserType(user.getUserType());
            generateToken();

            user.update(Map.ofEntries(
                    Map.entry("token", getToken())
            ));

            return true;
        }

        return false;
    }

    public static String getTable_name() {
        return table_name;
    }

    public String getToken() {
        return token;
    }
    /*
        Generates a random token for the user
     */
    public void generateToken() {
        final SecureRandom secureRandom = new SecureRandom();
        final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

        byte[] randomBytes = new byte[72];
        secureRandom.nextBytes(randomBytes);
        String token = base64Encoder.encodeToString(randomBytes);
        setToken(token);
        update(Map.ofEntries(
                Map.entry("token", token)
        ));
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static User findUser(String token){
        ArrayList<User> u = new User().where("token", "like", token).get();
        if(u.isEmpty()) return null;
        return u.get(0);
    }
}
















