import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User extends Model
{
    private static final String table_name = "user";

    public int id;
    public String username;
    public String password;
    public String userType;
    public int contactId;
    public int billingId;

    public User() {
        super(table_name);
        this.id = -1;
        this.username = null;
        this.password = null;
        this.userType = null;
        this.contactId = -1;
        this.billingId = -1;
    }

    public User(int id, String username, String password, String userType, int contactId, int billingId) {
        super(table_name);
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.contactId = contactId;
        this.billingId = billingId;
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
        return "User{" +
                ", id=" + id +
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
}