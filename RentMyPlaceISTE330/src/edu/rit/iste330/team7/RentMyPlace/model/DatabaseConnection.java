package edu.rit.iste330.team7.RentMyPlace.model;

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
    public ResultSet getResultSet(String sql) throws DLException {

        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = (Statement) this.getCon().createStatement();
            return stmt.executeQuery(sql);
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
    public int executeQuery(String sql) throws DLException {
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