package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Permission extends Model
{
    private static final String table_name = "permissions";

    public int id;
    public String route;
    public String role;

    public Permission() {
        super(table_name);
        this.id = -1;
        this.route = null;
        this.role = null;
    }

    public Permission(int id, String route, String role) {
        super(table_name);
        this.id = id;
        this.route = route;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute() { return route; }

    public void setRoute(String route) { this.route = route; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Permission assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "route" -> this.setRoute(row.get(attribute));
                case "role" -> this.setRole(row.get(attribute));
            }
        }
        return this;
    }


    @Override
    public ArrayList<Permission> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Permission> permissions = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Permission permission = new Permission();
            permission.assign(row);
            permissions.add(permission);
        }
        return permissions;
    }

    public Permission create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates edu.rit.iste330.team7.RentMyPlace.model.Contact table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return edu.rit.iste330.team7.RentMyPlace.model.Contact
     */
    public Permission update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a edu.rit.iste330.team7.RentMyPlace.model.Contact instance based on the id, calls super deleteModel() to perform needed task
     * @return edu.rit.iste330.team7.RentMyPlace.model.Contact
     */
    public Permission delete(){
        super.deleteModel(this.id);
        return this;
    }
}