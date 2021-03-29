import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Property extends Model
{
    private static String table_name = "property";

    public int id;
    public int userId;
    public int locationId;
    public int ownerId;
    public String description;
    public int propertyTypeId;
    public String imagePath;
    public int bedrooms;
    public int size;
    public double pricePerNight;

    public Property() {
        super(table_name);
        this.id = -1;
        this.userId = -1;
        this.locationId = -1;
        this.ownerId = -1;
        this.description = null;
        this.propertyTypeId = -1;
        this.imagePath =  null;
        this.bedrooms = -1;
        this.size = -1;
        this.pricePerNight = -1;
    }

    public Property(int id, int userId, int locationId, int ownerId, String description, int propertyTypeId, String imagePath, int bedrooms, int size, double pricePerNight) {
        super(table_name);
        this.id = id;
        this.userId = userId;
        this.locationId = locationId;
        this.ownerId = ownerId;
        this.description = description;
        this.propertyTypeId = propertyTypeId;
        this.imagePath = imagePath;
        this.bedrooms = bedrooms;
        this.size = size;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", userId=" + userId +
                ", locationId=" + locationId +
                ", ownerId=" + ownerId +
                ", description='" + description + '\'' +
                ", propertyTypeId=" + propertyTypeId +
                ", imagePath='" + imagePath + '\'' +
                ", bedrooms=" + bedrooms +
                ", size=" + size +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(int propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public ArrayList<Property> get() {
        ArrayList<HashMap<String,String>> list_of_rows = super.getData();
        ArrayList<Property> properties = new ArrayList<Property>();

        for (HashMap<String, String> row: list_of_rows) {
            Property property = new Property();
            for (String attribute: row.keySet()) {
                switch (attribute) {
                    case "id": property.setId(Integer.parseInt(row.get(attribute))); break;
                    case "userId": property.setUserId(Integer.parseInt(row.get(attribute))); break;
                    case "locationId": property.setLocationId(Integer.parseInt(row.get(attribute))); break;
                    case "ownerId": property.setOwnerId(Integer.parseInt(row.get(attribute))); break;
                    case "description": property.setDescription(row.get(attribute)); break;
                    case "propertyTypeId": property.setPropertyTypeId(Integer.parseInt(row.get(attribute))); break;
                    case "imagePath": property.setImagePath(row.get(attribute)); break;
                    case "bedrooms": property.setBedrooms(Integer.parseInt(row.get(attribute))); break;
                    case "size": property.setSize(Integer.parseInt(row.get(attribute))); break;
                    case "pricePerNight": property.setPricePerNight(Double.parseDouble(row.get(attribute))); break;
                }
            }
            properties.add(property);
        }
        return properties;
    }
}