import java.util.ArrayList;

public class Property extends Model
{
    private static String table_name = "products";

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
}