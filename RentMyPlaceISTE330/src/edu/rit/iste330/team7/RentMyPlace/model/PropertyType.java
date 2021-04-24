package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the PropertyType table
 */
public class PropertyType extends Model
{
    //attributes
    private static final String table_name = "property_type";

    public int id;
    public String type;

    //default constructor
    public PropertyType() {
        super(table_name);
        this.id = -1;
        this.type = null;
    }

    //parametrized constructor
    public PropertyType(int id, String type) {
        super(table_name);
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "edu.rit.iste330.team7.RentMyPlace.model.PropertyType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * Assigns new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return PropertyType
     */
    public PropertyType assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "type" -> this.setType(row.get(attribute));
            }
        }
        return this;
    }

    /**
     * Gets PropertyType table data
     * @return ArrayList<PropertyType>
     */
    @Override
    public ArrayList<PropertyType> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<PropertyType> propertyTypes = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            PropertyType propertyType = new PropertyType();
            propertyType.assign(row);
            propertyTypes.add(propertyType);
        }
        return propertyTypes;
    }
    /**
     * Creates an new instance of PropertyType
     * @param row Map<String, String>
     * @return PropertyType
     */
    public PropertyType create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.PropertyType table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.PropertyType
     */
    public PropertyType update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.PropertyType instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.PropertyType
     */
    public PropertyType delete(){
        super.deleteModel(this.id);
        return this;
    }
}