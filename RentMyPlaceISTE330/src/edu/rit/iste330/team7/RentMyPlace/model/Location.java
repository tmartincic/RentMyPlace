package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the Location table
 */
public class Location extends Model
{
    //attributes
    private static final String table_name = "location";

    public int id;
    public String street;
    public String city;
    public int zip;

    //default constructor
    public Location() {
        super(table_name);
        this.id = -1;
        this.street = null;
        this.city = null;
        this.zip = -1;
    }

    //parametrized constructor
    public Location(int id, String street, String city, int zip) {
        super(table_name);
        this.id = id;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    /**
     * Gettes and setters
     */

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
        return "edu.rit.iste330.team7.RentMyPlace.model.Location{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }

    /**
     * Assings new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return Location
     */
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

    /**
     * Gets Location table data
     * @return ArrayList<Location>
     */
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

    /**
     * Creates a new Location
     * @param row Map<String, String>
     * @return Location
     */
    public Location create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Location table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Location
     */
    public Location update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Location instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Location
     */
    public Location delete(){
        super.deleteModel(this.id);
        return this;
    }
}