import java.sql.Date;

public class Reservations
{
    public int userId;
    public int propertyId;
    public java.sql.Date from;
    public java.sql.Date to;
    public double price;

    public Reservations() {
        this.userId = -1;
        this.propertyId = -1;
        this.from = null;
        this.to = null;
        this.price = -1;
    }

    public Reservations(int userId, int propertyId, Date from, Date to, double price) {
        this.userId = userId;
        this.propertyId = propertyId;
        this.from = from;
        this.to = to;
        this.price = price;
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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}