
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.*;

public class DatabaseConnection {

    /*
        DATABASE CREDENTIAL CONSTANTS
     */
    private static String url = "";
    private static String host = "localhost";
    private static String port = "3306";
    private static String database = "rent_my_place";
    private static String user = "root";
    private static String password = "";
    private Connection con;

    public DatabaseConnection() { generateUrl(); }

    /*
        Execute SQL Querry and return resultSet or null
     */
    public ResultSet getResultSet(String sql) {

        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = (Statement) this.getCon().createStatement();
            return stmt.executeQuery(sql);
        }
        catch (SQLSyntaxErrorException sqlse) {
            System.out.println("Query not formed correctly: " + sqlse.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        Execute SQL Query
        Returns ID of inserted column
     */
    public int executeQuery(String sql) {
        try{
            PreparedStatement stmt = (PreparedStatement) this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        }
        catch (SQLSyntaxErrorException sqlse) {
            System.out.println("Insert not formed correctly: " + sqlse.getMessage());
            return -1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean connect() {
        try{
            this.con= (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            return true;
        }catch(SQLException sqle) {
            System.out.println(sqle.getSQLState());
            System.out.println(sqle.getErrorCode());
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try{
            this.con.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String getPort() {
        return port;
    }
    public String getHost() {
        return host;
    }
    public String getDatabase() {
        return database;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public Connection getCon() {
        return con;
    }
    public void generateUrl() {
        this.url = "jdbc:mysql://"+host+":"+port+"/"+database;
    }

    public void setHost(String host) {
        this.host = host;
        generateUrl();
    }

    public void setPort(String port) {
        this.port = port;
        generateUrl();
    }


    public void setDatabase(String database) {
        this.database = database;
        generateUrl();
    }


    public void setUser(String user) {
        this.user = user;
        generateUrl();
    }

    public void setPassword(String password) {
        this.password = password;
        generateUrl();
    }

    public void setCon(Connection con) {
        this.con = con;
        generateUrl();
    }
}  