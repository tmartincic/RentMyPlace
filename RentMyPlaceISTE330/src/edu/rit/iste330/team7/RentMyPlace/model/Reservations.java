package edu.rit.iste330.team7.RentMyPlace.model;

import java.sql.Date;
import java.util.*;

/**
 * Model class for the Reservations table
 */
public class Reservations extends Model
{
   //attributes
   private static String table_name = "reservations";    

   public int id;
   public int userId;
   public int propertyId;
   public java.sql.Date arrivalDate;
   public java.sql.Date departureDate;
   public double price;

   //default constructor
   public Reservations() {
      super(table_name);
      this.id = -1;
      this.userId = -1;
      this.propertyId = -1;
      this.arrivalDate = null;
      this.departureDate = null;
      this.price = -1;
   }

   //parametrized constructor
   public Reservations(int id, int userId, int propertyId, Date arrivalDate, Date departureDate, double price) {
      super(table_name);
      this.id = id;
      this.userId = userId;
      this.propertyId = propertyId;
      this.arrivalDate = arrivalDate;
      this.departureDate = departureDate;
      this.price = price;
   }

   @Override
   public String toString() {
      return "edu.rit.iste330.team7.RentMyPlace.model.Reservations{" +
              "id=" + id +
              ", userId=" + userId +
              ", propertyId=" + propertyId +
              ", arrivalDate=" + arrivalDate +
              ", departureDate=" + departureDate +
              ", price=" + price +
              '}';
   }

   /**
    * Getters and setters
    */
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

   /**
    * Assigns new values to the attributes
    * @param row Map<String, String> map of attributes and values
    * @return Reservations
    */
   public Reservations assign(Map<String, String> row) {
      for (String attribute: row.keySet()) {
         switch (attribute) {
            case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
            case "userId" -> this.setUserId(Integer.parseInt(row.get(attribute)));
            case "propertyId" -> this.setPropertyId(Integer.parseInt(row.get(attribute)));
            case "arrivalDate" -> this.setarrivalDate(Date.valueOf(row.get(attribute)));
            case "departureDate" -> this.setdepartureDate(Date.valueOf(row.get(attribute)));
            case "price" -> this.setPrice(Double.parseDouble(row.get(attribute)));
         }
      }
      return this;
   }

   /**
    * Gets Reservations table data
    * @return ArrayList<Reservations>
    */
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

   /**
    * Creates an new instance of Reservations
    * @param row Map<String, String>
    * @return Reservations
    */
   public Reservations create(Map<String, String> row) {
      int id = super.createModel(row);
      setUserId(userId);
      this.assign(row);
      return this;
   }

   /**
    * Updates edu.rit.iste330.team7.RentMyPlace.model.Reservations table, calls super updateModel() to perform needed task
    *               <column, value>
    * @param row Map<String, String>
    * @return edu.rit.iste330.team7.RentMyPlace.model.Reservations
    */
   public Reservations update(Map<String, String> row){
      super.updateModel(row, this.id);
      this.assign(row);
      return this;
   }

   /**
    * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Reservations instance based on the id, calls super deleteModel() to perform needed task
    * @return edu.rit.iste330.team7.RentMyPlace.model.Reservations
    */
   public Reservations delete(){
      super.deleteModel(this.id);
      return this;
   }
}