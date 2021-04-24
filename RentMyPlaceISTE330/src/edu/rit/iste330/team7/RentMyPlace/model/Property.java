package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the Property table
 */
public class Property extends Model implements Comparable
{
    //attributes
    private static String table_name = "property";

    public int id;
    public int userId;
    public int locationId;
    public String propertyName;
    public String description;
    public int propertyTypeId;
    public String imagePath;
    public int bedrooms;
    public int size;
    public double pricePerNight;

    //default constructor
    public Property() {
        super(table_name);
        this.id = -1;
        this.userId = -1;
        this.locationId = -1;
        this.propertyName = null;
        this.description = null;
        this.propertyTypeId = -1;
        this.imagePath =  null;
        this.bedrooms = -1;
        this.size = -1;
        this.pricePerNight = -1;
    }

    //parametrized constructor
    public Property(int id, int userId, int locationId, String propertyName, String description, int propertyTypeId, String imagePath, int bedrooms, int size, double pricePerNight) {
        super(table_name);
        this.id = id;
        this.userId = userId;
        this.locationId = locationId;
        this.description = description;
        this.propertyName = propertyName;
        this.propertyTypeId = propertyTypeId;
        this.imagePath = imagePath;
        this.bedrooms = bedrooms;
        this.size = size;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "edu.rit.iste330.team7.RentMyPlace.model.Property{" +
                "id=" + id +
                ", userId=" + userId +
                ", locationId=" + locationId +
                ", description='" + description + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyTypeId=" + propertyTypeId +
                ", imagePath='" + imagePath + '\'' +
                ", bedrooms=" + bedrooms +
                ", size=" + size +
                ", pricePerNight=" + pricePerNight +
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getPropertyName(){ return propertyName; }

    public void setPropertyName(String propertyName){ this.propertyName = propertyName; }

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

    /**
     * Assigns new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return Property
     */
    public Property assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id": this.setId(Integer.parseInt(row.get(attribute))); break;
                case "userId": this.setUserId(Integer.parseInt(row.get(attribute))); break;
                case "locationId": this.setLocationId(Integer.parseInt(row.get(attribute))); break;
                case "propertyName": this.setPropertyName(row.get(attribute)); break;
                case "description": this.setDescription(row.get(attribute)); break;
                case "propertyTypeId": this.setPropertyTypeId(Integer.parseInt(row.get(attribute))); break;
                case "imagePath": this.setImagePath(row.get(attribute)); break;
                case "bedrooms": this.setBedrooms(Integer.parseInt(row.get(attribute))); break;
                case "size": this.setSize(Integer.parseInt(row.get(attribute))); break;
                case "pricePerNight": this.setPricePerNight(Double.parseDouble(row.get(attribute))); break;
            }
        }
        return this;
    }

    /**
     * Gets Property table data
     * @return ArrayList<Property>
     */
    @Override
    public ArrayList<Property> get() {
        ArrayList<HashMap<String,String>> list_of_rows = super.getData();
        ArrayList<Property> properties = new ArrayList<Property>();

        try{
            for (HashMap<String, String> row: list_of_rows) {
                Property property = new Property();
                property.assign(row);
                properties.add(property);
            }
            return properties;
        }
        catch (NullPointerException npe) {
            System.out.println("0 rows retrieved from the database: "+sqlToString());
        }
        return null;
    }

    //persist to database, assign variables (without performing another select query)
    //and set ID (because we cannot add it to immutableMap (row)), return
    public Property create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Property table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Property
     */
    public Property update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Property instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Property
     */
    public Property delete(){
        super.deleteModel(this.id);
        return this;
    }

    @Override
    public int compareTo(Object comparedTo) {
        double diff = 0;
        Property prop = null;
        if(comparedTo instanceof Property) prop = (Property)comparedTo;
        if(prop != null) diff = getPricePerNight() - prop.getPricePerNight();
        return (int) Math.floor(diff);
    }
}