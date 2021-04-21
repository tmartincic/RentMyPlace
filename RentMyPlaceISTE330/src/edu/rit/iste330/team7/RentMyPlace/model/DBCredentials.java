package edu.rit.iste330.team7.RentMyPlace.model;

public class DBCredentials {
    /*
        Default dev credentials
     */
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_DATABASE = "rent_my_place";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static String readFile() {
        return "readfilehere";
    }

    public static String getDbHost() {


        return DB_HOST;
    }

    public static String getDbPort() {
        return DB_PORT;
    }

    public static String getDbDatabase() {
        return DB_DATABASE;
    }

    public static String getDbUsername() {
        return DB_USERNAME;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }
}
