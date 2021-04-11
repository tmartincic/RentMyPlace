package edu.rit.iste330.team7.RentMyPlace.model;

import java.io.*;
import java.sql.*;

/**
 * Class for custom exception handling
 */
public class DLException extends Exception{
    private BufferedWriter logger = null;
    // constructor
    public DLException(SQLException sqlException){
        super("The operation can not be completed. Please contact the administrator.");
        this.log(sqlException);
    }

    public DLException(SQLSyntaxErrorException sqlException, String stmt){
        super("The operation can not be completed. Please contact the administrator.");
        this.log(sqlException, stmt);
    }

    //constructor
    public DLException(Exception exception){
        super("The operation can not be completed. Please contact the administrator.");
        this.log(exception);
    }

    /**
     * Method for logging SQLSyntaxErrorException
     * @param sqlException SQLSyntaxErrorException
     * @param stmt String
     */
    public void log(SQLSyntaxErrorException sqlException, String stmt){
        String exceptionOutput = "Query: " + stmt + "\nSQL state code: " + sqlException.getSQLState() + "\nError code: " + sqlException.getErrorCode() + "\nCause: " + sqlException.getCause() + "\nMessage: " + sqlException.getMessage() + "\n";
        StackTraceElement item = sqlException.getStackTrace()[0];
        exceptionOutput += "CLASS: "+item.getClassName()+"\n";
        exceptionOutput += "LINE: "+item.getLineNumber()+"\n";


        this.write(exceptionOutput);
    }

    /**
     * Method for logging SQLException
     * @param sqlException SQLException
     */
    public void log(SQLException sqlException){
        String exceptionOutput = "SQL state code: " + sqlException.getSQLState() + "\nError code: " + sqlException.getErrorCode() + "\nCause: " + sqlException.getCause() + "\nMessage: " + sqlException.getMessage() + "\n";
        StackTraceElement item = sqlException.getStackTrace()[0];
        exceptionOutput += "CLASS: "+item.getClassName()+"\n";
        exceptionOutput += "LINE: "+item.getLineNumber()+"\n";


        this.write(exceptionOutput);
    }

    /**
     * Method for logging Exception
     * @param exception Exception
     */
    public void log(Exception exception){
        String exceptionOutput = "Cause: " + exception.getCause() + " \nMessage: " + exception.getMessage() + " \nMessage: " + exception.getStackTrace()+"\n";
        StackTraceElement item = exception.getStackTrace()[0];
        exceptionOutput += "CLASS: "+item.getClassName()+"\n";
        exceptionOutput += "LINE: "+item.getLineNumber()+"\n";

        this.write(exceptionOutput);
    }

    /**
     * Writes given logging information to a log file
     * @param error String
     * @return boolean
     */
    public boolean write(String error){
        try{
            logger = new BufferedWriter(new FileWriter(new File("log.txt"), true));
            logger.write("Timestamp: " + this.getTimestamp() + "\n" + error + "\n");
            logger.flush();
            logger.close();

            return true;
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }

    /**
     * Method for creating a timestamp
     * @return String
     */
    public String getTimestamp(){
        java.sql.Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }
}
