package edu.rit.iste330.team7.RentMyPlace.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Model class for the Permission table
 */
public class Permission extends Model
{
    //attributes
    private static final String table_name = "permissions";

    public int id;
    public String route;
    public String role;

    //default constructor
    public Permission() {
        super(table_name);
        this.id = -1;
        this.route = null;
        this.role = null;
    }

    //parametrized constructor
    public Permission(int id, String route, String role) {
        super(table_name);
        this.id = id;
        this.route = route;
        this.role = role;
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

    public String getRoute() { return route; }

    public void setRoute(String route) { this.route = route; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    /**
     * Assigns new values to the attributes
     * @param row Map<String, String> map of attributes and values
     * @return Permission
     */
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

    /**
     * Gets Permission table data
     * @return ArrayList<Permission>
     */
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

    /**
     * Creates an new instance of Permission
     * @param row Map<String, String>
     * @return Permission
     */
    public Permission create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }

    /**
     * Updates Permission table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return Permission
     */
    public Permission update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a Permission instance based on the id, calls super deleteModel() to perform needed task
     * @return Permission
     */
    public Permission delete(){
        super.deleteModel(this.id);
        return this;
    }
}