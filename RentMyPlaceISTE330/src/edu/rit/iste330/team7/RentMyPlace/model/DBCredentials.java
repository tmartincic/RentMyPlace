package edu.rit.iste330.team7.RentMyPlace.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DBCredentials {
    /*
        Default dev credentials
     */
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_DATABASE = "rent_my_place";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static final String LOCAL_CREDENTIALS = "db_credentials.txt";

    /***
     *  This method reads a local credentials file and returns
     *  hashmap of credentials. Missing values will default to
     *  development credentials.
     * @return HashMap<String, String>
     */
    public static HashMap<String,String> readFile() {
        HashMap<String, String> credentials = new HashMap<>();
        try {
            File myObj = new File(LOCAL_CREDENTIALS);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] kv = data.split("=");
                try{
                    credentials.put(kv[0], kv[1]);
                }
                catch (IndexOutOfBoundsException ioe) {
                    continue;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            DBCredentials.generateFile();
            readFile();
        }
        catch (Exception e) {
            return new HashMap<String, String>();
        }

        return credentials;
    }

    /***
     * This method generates db_credentials.txt template if
     * it is missing from the directory. It will default to
     * development server credentials.
     */
    public static void generateFile() {
        try {
            File myObj = new File(LOCAL_CREDENTIALS);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter(LOCAL_CREDENTIALS);
                myWriter.write("host=" + DB_HOST);
                myWriter.write("port=" + DB_PORT);
                myWriter.write("database=" + DB_DATABASE);
                myWriter.write("username=" + DB_USERNAME);
                myWriter.write("password=" + DB_PASSWORD);
                myWriter.flush();
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating the db_credentials template.");
        }
    }

    /***
     * Getters for database credentials. Will default
     * to development credentials if value not found.
     * @return
     */
    public static String getDbHost() {
        String host = DBCredentials.readFile().get("host");
        return host == null ? DB_HOST : host;
    }

    public static String getDbPort() {
        String port = DBCredentials.readFile().get("port");
        return port == null ? DB_PORT : port;
    }

    public static String getDbDatabase() {
        String database = DBCredentials.readFile().get("database");
        return database == null ? DB_DATABASE : database;
    }

    public static String getDbUsername() {
        String username = DBCredentials.readFile().get("username");
        return username == null ? DB_USERNAME : username;
    }

    public static String getDbPassword() {
        String password = DBCredentials.readFile().get("password");
        return password == null ? DB_PASSWORD : password;
    }
}
