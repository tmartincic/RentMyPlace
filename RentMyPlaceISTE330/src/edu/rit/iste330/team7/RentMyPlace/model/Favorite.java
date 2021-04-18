package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Favorite extends Model
{
    private static final String table_name= "favorite";

    public int id;
    public int userId;
    public int propertyId;

    public Favorite() {
        super(table_name);
        this.id = -1;
        this.userId = -1;
        this.propertyId = -1;
    }

    public Favorite(int id, int userId, int propertyId) {
        super(table_name);
        this.id = id;
        this.userId = userId;
        this.propertyId = propertyId;
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

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString(){
        return "edu.rit.iste330.team7.RentMyPlace.model.Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", propertyId=" + propertyId +
                '}';
    }

    public Favorite assign(Map<String, String> row){
        for(String attribute : row.keySet()) {
            switch(attribute) {
                case "id" : this.setId(Integer.parseInt(row.get(attribute))); break;
                case "userId" : this.setUserId(Integer.parseInt(row.get(attribute))); break;
                case "propertyId" : this.setPropertyId(Integer.parseInt(row.get(attribute))); break;
            }
        }
        return this;
    }
    @Override
    public ArrayList<Favorite> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Favorite> favorites = new ArrayList<>();

        try {
            for (HashMap<String, String> row : list_of_rows) {
                Favorite favorite = new Favorite();
                favorite.assign(row);
                favorites.add(favorite);
            }
            return favorites;
        }
        catch(NullPointerException e){
            System.out.println("0 rows retrieved from the database: "+sqlToString());
        }
        catch(NumberFormatException e){
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    public Favorite create(Map<String, String> row) {
        int id = super.createModel(row);
        setUserId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Favorite table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Favorite
     */
    public Favorite update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Favorite instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Favorite
     */
    public Favorite delete(){
        super.deleteModel(this.id);
        return this;
    }
}