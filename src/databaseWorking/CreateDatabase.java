package databaseWorking;

import utility.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public void createDatabase() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASS);

            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sqlDatabase = "CREATE DATABASE IF NOT EXISTS USERS";
            stmt.executeUpdate(sqlDatabase);


            System.out.println("Database created successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);

            System.out.println("Creating table...");
            stmt = conn.createStatement();

            String sqlTable = "CREATE TABLE IF NOT EXISTS " + "USERS" + " (" +
                    "username VARCHAR (50) UNIQUE NOT NULL, " +
                    "password VARCHAR (50) NOT NULL" + ")";

            stmt.executeUpdate(sqlTable);
            System.out.println("Database created successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}