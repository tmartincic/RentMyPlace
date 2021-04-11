package edu.rit.iste330.team7.RentMyPlace.model;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

import javax.lang.model.type.PrimitiveType;
import java.util.*;

public class DatabaseConnection {

    /*
        DATABASE CREDENTIAL CONSTANTS
     */
// Online database credentials
//    Host: sql11.freemysqlhosting.net
//    Database: sql11405004
//    Username: sql11405004
//    Password: zabN2sdjHZ
//    Port: 3306

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
    public ResultSet getResultSet(String sql, ArrayList<Object> values) throws DLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = (PreparedStatement) this.getCon().prepareStatement(sql);
            if(!values.isEmpty()){
                for(int i=0; i<values.size(); i++) stmt.setObject((i+1), values.get(i));
            }

            return stmt.executeQuery();
        }
        catch (SQLSyntaxErrorException sqlse) {
            throw new DLException(sqlse, sql);
        }
        catch (Exception e) {
            throw new DLException(e);
        }
    }

    /*
        Execute SQL Query
        Returns ID of inserted column
     */
    public int executeQuery(String sql, ArrayList<Object> values) throws DLException {
        try{
            PreparedStatement stmt = (PreparedStatement) this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if(!values.isEmpty()){
                for(int i=0; i<values.size(); i++) stmt.setObject((i+1), values.get(i));
            }
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        }
        catch (SQLSyntaxErrorException sqlse) {
            throw new DLException(sqlse, sql);
        }
        catch (Exception e) {
            throw new DLException(e);
        }
    }

    public boolean connect() throws DLException {
        try{
            this.con= (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            return true;
        }catch(SQLException sqle) {
            throw new DLException(sqle);
        }
    }

    public boolean close() throws DLException {
        try{
            this.con.close();
            return true;
        }
        catch(Exception e){
            throw new DLException(e);
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
        this.url = "jdbc:mysql://"+host+":"+port+"/"+database+"?serverTimezone=CET";
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