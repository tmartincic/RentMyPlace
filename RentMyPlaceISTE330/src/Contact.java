public class Contact
{
    public int id;
    public String fullName;
    public String email;
    public int phone;
    public int locationId;

    public Contact() {
        this.id = -1;
        this.fullName = null;
        this.email = null;
        this.phone = -1;
        this.locationId = -1;
    }

    public Contact(int id, String fullName, String email, int phone, int locationId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationId = locationId;
    }

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
}