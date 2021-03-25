public class Favorite
{
    public int userId;
    public int propertyId;

    public Favorite() {
        this.userId = -1;
        this.propertyId = -1;
    }

    public Favorite(int userId, int propertyId) {
        this.userId = userId;
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
}