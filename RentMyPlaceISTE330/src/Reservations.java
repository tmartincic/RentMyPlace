import java.sql.Date;
import java.util.*;

public class Reservations extends Model
{
   private static String table_name = "reservations";    

   public int userId;
   public int propertyId;
   public java.sql.Date arrivalDate;
   public java.sql.Date departureDate;
   public double price;

   public Reservations() {
      super(table_name);
      this.userId = -1;
      this.propertyId = -1;
      this.arrivalDate = null;
      this.departureDate = null;
      this.price = -1;
   }

   public Reservations(int userId, int propertyId, Date arrivalDate, Date departureDate, double price) {
      super(table_name);
      this.userId = userId;
      this.propertyId = propertyId;
      this.arrivalDate = arrivalDate;
      this.departureDate = departureDate;
      this.price = price;
   }

   @Override
   public String toString() {
      return "Reservations{" +
              ", userId=" + userId +
              ", propertyId=" + propertyId +
              ", arrivalDate=" + arrivalDate +
              ", departureDate=" + departureDate +
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

   public Date getArrivalDate() {
      return arrivalDate;
   }

   public void setarrivalDate(Date arrivalDate) {
      this.arrivalDate = arrivalDate;
   }

   public Date getdepartureDate() {
      return departureDate;
   }

   public void setdepartureDate(Date departureDate) {
      this.departureDate = departureDate;
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
            case "arrivalDate" -> this.setarrivalDate(Date.valueOf(row.get(attribute)));
            case "departureDate" -> this.setdepartureDate(Date.valueOf(row.get(attribute)));
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