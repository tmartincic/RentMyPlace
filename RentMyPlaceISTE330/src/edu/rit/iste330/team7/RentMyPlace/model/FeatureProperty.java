package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the FeatureProperty table
 */
public class FeatureProperty extends Model
{
    //attributes
    private static final String table_name = "feature_property";

    public int propertyId;
    public int featureId;

    //default constructor
    public FeatureProperty() {
        super(table_name);
        this.propertyId = -1;
        this.featureId = -1;
    }

    //default constructor
    public FeatureProperty(int propertyId, int featureId) {
        super(table_name);
        this.propertyId = propertyId;
        this.featureId = featureId;
    }

    /**
     * Getters and setters
     */

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    @Override
    public String toString() {
        return "edu.rit.iste330.team7.RentMyPlace.model.FeatureProperty{" +
                "propertyId=" + propertyId +
                ", featureId=" + featureId +
                '}';
    }

    /**
     * Assigns new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return FeatureProperty
     */
    public FeatureProperty assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "propertyId" -> this.setPropertyId(Integer.parseInt(row.get(attribute)));
                case "featureId" -> this.setFeatureId(Integer.parseInt(row.get(attribute)));
            }
        }
        return this;
    }

    /**
     * Gets FeatureProperty table data
     * @return ArrayList<FeatureProperty>
     */
    @Override
    public ArrayList<FeatureProperty> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<FeatureProperty> featureProperties = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            FeatureProperty featureProperty = new FeatureProperty();
            featureProperty.assign(row);
            featureProperties.add(featureProperty);
        }
        return featureProperties;
    }

    /**
     * Creates an new instance of FeatureProperty
     * @param row Map<String, String>
     * @return FeatureProperty
     */
    public FeatureProperty create(Map<String, String> row) {
        int id = super.createModel(row);
        setPropertyId(id);
        this.assign(row);
        return this;
    }
}