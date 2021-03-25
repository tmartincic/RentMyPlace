public class User
{
    public int id;
    public String username;
    public String password;
    public String userType;
    public int contactId;
    public int billingId;

    public User() {
        this.id = -1;
        this.username = null;
        this.password = null;
        this.userType = null;
        this.contactId = -1;
        this.billingId = -1;
    }

    public User(int id, String username, String password, String userType, int contactId, int billingId) {
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
}