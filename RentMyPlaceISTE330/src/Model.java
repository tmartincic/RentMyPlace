import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model<T> {
    private String table_name;
    private boolean is_stored_in_database;

    private String sql_string, select, from, whereSql, order = "";
    boolean firstWhere = true;
    //quick space and comma references for sql construction
    private String s = " ";
    private String c = ",";

    public Model (String table) {
        this.table_name = table;
        this.select = "SELECT *";
        this.from = "FROM "+table;
    }

    //SELECT `id`, `name`, `price` FROM `products` WHERE price < 15;

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
        if(firstWhere) this.whereSql = "WHERE" +s+ attribute +s+ operator +s+ value;
        else this.whereSql += s+chain +s+ attribute +s+ operator +s+ value;
        firstWhere = false;
        return this;
    }

    public String sqlToString() {
        //construct pieces and return
        this.sql_string = this.select +s+ this.from +s+ this.whereSql +s+ this.order;
        return sql_string;
    }

    public Model orderBy(String[] attributes, String asc) {
        this.order = "ORDER BY ";
        for (int i = 0; i < attributes.length; i++) {
            if(i == attributes.length-1) this.order += attributes[i] +s;
            else this.order += attributes[i] +c+s;
        }
        return this;
    }

    public ArrayList<T> get() {
        DatabaseConnection con = new DatabaseConnection();
        con.connect();
        ResultSet rs = con.executeQuery(sqlToString());
        int row = 0;
        try{
            while(rs.next()) {
                ArrayList<String> rowData = new ArrayList<String>();
                for(int index=1; index <= rs.getMetaData().getColumnCount(); index++) {
                    System.out.println(rs.getString(index));
                }
                System.out.println("########NEXT##############");
                row++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<T>();
    }
}
