public class Location
{
    public int id;
    public String street;
    public String city;
    public int zip;

    public Location() {
        this.id = -1;
        this.street = null;
        this.city = null;
        this.zip = -1;
    }

    public Location(int id, String street, String city, int zip) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}