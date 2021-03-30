import java.sql.Date;
import java.util.*;

public class Reservations extends Model
{
   private static String table_name = "reservations";    

   public int userId;
   public int propertyId;
   public java.sql.Date from;
   public java.sql.Date to;
   public double price;

   public Reservations() {
      super(table_name);
      this.userId = -1;
      this.propertyId = -1;
      this.from = null;
      this.to = null;
      this.price = -1;
   }

   public Reservations(int userId, int propertyId, Date from, Date to, double price) {
      super(table_name);
      this.userId = userId;
      this.propertyId = propertyId;
      this.from = from;
      this.to = to;
      this.price = price;
   }

   @Override
   public String toString() {
      return "Reservations{" +
              ", userId=" + userId +
              ", propertyId=" + propertyId +
              ", from=" + from +
              ", to=" + to +
              ", price=" + price +
              '}';
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

   public Reservations assign(Map<String, String> row) {
      for (String attribute: row.keySet()) {
         switch (attribute) {
            case "userId" -> this.setUserId(Integer.parseInt(row.get(attribute)));
            case "propertyId" -> this.setPropertyId(Integer.parseInt(row.get(attribute)));
            case "from" -> this.setFrom(Date.valueOf(row.get(attribute)));
            case "to" -> this.setTo(Date.valueOf(row.get(attribute)));
            case "price" -> this.setPrice(Double.parseDouble(row.get(attribute)));
         }
      }
      return this;
   }

   @Override
   public ArrayList<Reservations> get() {
      ArrayList<HashMap<String, String>> list_of_rows = super.getData();
      ArrayList<Reservations> reservations = new ArrayList<Reservations>();

      for(HashMap<String, String> row : list_of_rows) {
         Reservations reservation = new Reservations();
         reservation.assign(row);
         reservations.add(reservation);
      }
      return reservations;
   }

   public Reservations create(Map<String, String> row) {
      int id = super.createModel(row);
      setUserId(userId);
      this.assign(row);
      return this;
   }

}