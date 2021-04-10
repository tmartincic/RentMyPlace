package edu.rit.iste330.team7.RentMyPlace.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Class model represents a model, a table in the database.
    Each class extending edu.rit.iste330.team7.RentMyPlace.model.Model should set constant table_name to it's table name
    and should start every constructor with super(table_name);

    Also, each class should @Override get() method and set attributes as their own
 */
public class Model<T> {
    private String table_name;
    private boolean is_stored_in_database;

    private String sql_string, select, from, whereSql, order = "";
    boolean firstWhere = true;
    //quick space and comma references for sql construction
    private String s = " ";
    private String c = ",";
    private String sq = "'";

    public Model (String table) {
        this.table_name = table;
        this.select = "SELECT *";
        this.from = "FROM " + table;
        this.whereSql = "WHERE 1";
    }
    /*
        Used to build select part of query
     */
    public Model select(String[] attributes) {
        this.select = "SELECT ";
        for (int i = 0; i < attributes.length; i++) {
            if(i == attributes.length-1) this.select += attributes[i] +s;
            else this.select += attributes[i] +c+s;
        }
        return this;
    }

    /*
        Persists row to the database and
        returns the ID of inserted model
     */
    public int createModel(Map<String, String> row) {
        String sq = "'";
        String query = "INSERT INTO " + this.table_name + "(";
        for (String attribute: row.keySet()) query += attribute +c;
        query = query.substring(0, query.length() - 1); //remove last comma
        query += ") VALUES (";
        for (String attribute: row.values()) query +=  sq+attribute +sq+c;
        query = query.substring(0, query.length() - 1); //remove last comma
        query += ");";

        DatabaseConnection con = new DatabaseConnection();
        int id = 0;
        try {
            con.connect();
            id = con.executeQuery(query);
            con.close();
        }
        catch(DLException e){
            System.out.println(e);
        }
        return id;
    }

    /*
        Used to build where part of query and to chain with AND operator
     */
    public Model where(String attribute, String operator, String value) {
        this._where(attribute, operator, value, "AND");
        return this;
    }

    /*
        Used to build where part of query and to chain with OR operator
     */
    public Model orWhere(String attribute, String operator, String value) {
        this._where(attribute, operator, value, "OR");
        return this;
    }

    /*
        Used to build AND where part of query
        Defaults to AND where, for OR operator check orWhere() function
     */
    private Model _where(String attribute, String operator, String value, String chain) {
        String valueFormated = "";
        //If we are dealing with numeric value, leave as is, if we're dealing with string, add single quotes
        try{
            Double.parseDouble(value);
            valueFormated = value;
        }
        catch (NumberFormatException nfe) {
            valueFormated = sq+value+sq;
        }
        if(firstWhere) this.whereSql = "WHERE" +s+ attribute +s+ operator +s+valueFormated;
        else this.whereSql += s+chain +s+ attribute +s+ operator +s+ valueFormated;
        firstWhere = false;
        return this;
    }

    /*
        Used to output built SQL string
     */
    public String sqlToString() {
        //construct pieces and return
        this.sql_string = this.select +s+ this.from +s+ this.whereSql +s+ this.order;
        return sql_string;
    }


    /*
        Used to build order by part of query
     */
    public Model orderBy(String[] attributes, String asc) {
        this.order = "ORDER BY ";
        for (int i = 0; i < attributes.length; i++) {
            if(i == attributes.length-1) this.order += attributes[i] +s;
            else this.order += attributes[i] +c+s;
        }
        return this;
    }

    /*
        This is generic method used to retrieve data from constructed SQL query,
        it returns ArrayList of rows. Each row is HashMap<String, String> which is
        logicaly equal to HashMap<Column, Value>. This way we can generically retrieve all
        columns in the same manner, and we only have to override the declaration of retrieved attributes, check the get() method.
     */
    public ArrayList<Map<String, String>>getData() {
        ArrayList<Property> properties = new ArrayList<Property>();
        DatabaseConnection con = new DatabaseConnection();
        try {
            con.connect();
        }
        catch(DLException e){
            System.out.println(e);
        }
        ResultSet rs = null;
        try {
            rs = con.getResultSet(sqlToString());
        }
        catch(DLException e){
            System.out.println(e);
        }
        //Array list of rows (each row is a HashMap<Column, Value>)
        ArrayList<Map<String, String>> column_value_list = new ArrayList<Map<String, String>>();
        try{
            while(rs.next()) {
                //This row map represents row in database and exists due to
                //SELECT query when we don't know  which columns will return, thus some variables
                //will be null and we cannot user rs.getString(const) because at same positions
                //we can get different attributes, depending on string
                HashMap<String, String> row = new HashMap<String, String>();
                for(int col = 1; col <= rs.getMetaData().getColumnCount(); col++) row.put(rs.getMetaData().getColumnName(col), rs.getString(col));
                column_value_list.add(row);
            }
        }
        catch (NullPointerException npe) {
            try {
                con.close();
            }
            catch(DLException e){
                System.out.println(e);
            }
            System.out.println("Result set from query is null.");
            return null;
        }
        catch (Exception e) {
            try {
                con.close();
            }
            catch(DLException dle){
                System.out.println(dle);
            }
            e.printStackTrace();
            return null;
        }
        try {
            con.close();
        }
        catch(DLException e){
            System.out.println(e);
        }
        if(column_value_list.size() == 0) System.out.println("No results were found in following query: "+sqlToString());
        return column_value_list;
    }

    /*
        This method should be overriden in EACH class extending edu.rit.iste330.team7.RentMyPlace.model.Model
        Exact structure is below, and should be used only as documented.
        Each class that extends model should @Override and copy this method,
        and refactor it as described below. This is due to SELECT statements being unpredictable and
        we have no way of knowing where in result we will recieve which column. Unless we create map of column_value pairs,
        this would be impossible.

        NOTE: THIS METHOD SHOULD BE COPIED AND USED IN FOLLOWING MANNER:
        CHECKLIST TO IMPLEMENT METHOD:
        If adding this to model edu.rit.iste330.team7.RentMyPlace.model.Property, be sure to change ArrayList<THIS_CLASS> to ArrayList<edu.rit.iste330.team7.RentMyPlace.model.Property>
        If adding this to model edu.rit.iste330.team7.RentMyPlace.model.Property, make sure method returns ArrayList<edu.rit.iste330.team7.RentMyPlace.model.Property> as in "public function ArrayList<edu.rit.iste330.team7.RentMyPlace.model.Property> get() {}"
        If adding this to model edu.rit.iste330.team7.RentMyPlace.model.Property, make sure you instantiate new edu.rit.iste330.team7.RentMyPlace.model.Property() in first for loop
        If adding this to model edu.rit.iste330.team7.RentMyPlace.model.Property, make sure you set all attributes inside switch(): NOTE: ATTRIBUTE NAMES ARE COLUMN NAMES IN DATABASE eg. case "column1" : thisClass.setColumn1()
        Once you added appropriate column to case, make sure to call appropriate setter and parse the input correctly
        row.get(attribute) piece of code is always the same and does not change
        Make sure you add break; to end of each case.

        It's best to check how edu.rit.iste330.team7.RentMyPlace.model.Property class has @Overridden this method and repeat
     */

    public ArrayList<T> get() {
        return new ArrayList<T>();
    };

    /**
     * Deletes certain row in a table based on the id
     * @param id int
     * @return boolean
     */
    public boolean deleteModel(int id) {
        String query = "DELETE FROM " + this.table_name + " WHERE id = " + id;

        DatabaseConnection con = new DatabaseConnection();
        try {
            con.connect();
            con.executeQuery(query);
            con.close();
        }
        catch(DLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * Updates table
     *               <column, value>
     * @param row Map<String, String>
     * @param id int
     * @return boolean
     */
    public boolean updateModel(Map<String, String> row, int id) {
        String sq = "'";
        String query = "UPDATE " + this.table_name + " SET ";
        String valueFormated = "";
        for (String attribute: row.keySet()) {
            try{
                Double.parseDouble(row.get(attribute));
                valueFormated = row.get(attribute);
            }
            catch (NumberFormatException nfe) {
                valueFormated = sq+row.get(attribute)+sq;
            }
            query += attribute + "=" + valueFormated + c;
        }
        query = query.substring(0, query.length() - 1); //remove last comma
        query += " WHERE id = " + id + ";";

        DatabaseConnection con = new DatabaseConnection();
        try {
            con.connect();
            con.executeQuery(query);
            con.close();
        }
        catch(DLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
