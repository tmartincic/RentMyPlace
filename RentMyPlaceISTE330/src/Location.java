import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Location extends Model
{
    private static final String table_name = "location";

    public int id;
    public String street;
    public String city;
    public int zip;

    public Location() {
        super(table_name);
        this.id = -1;
        this.street = null;
        this.city = null;
        this.zip = -1;
    }

    public Location(int id, String street, String city, int zip) {
        super(table_name);
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

    @Override
    public String toString() {
        return "Location{" +
                ", id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }

    public Location assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "street" -> this.setStreet(row.get(attribute));
                case "city" -> this.setCity(row.get(attribute));
                case "zip" -> this.setZip(Integer.parseInt(row.get(attribute)));
            }
        }
        return this;
    }
    @Override
    public ArrayList<Location> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Location> locations = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Location location = new Location();
            location.assign(row);
            locations.add(location);
        }
        return locations;
    }

    public Location create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }
}