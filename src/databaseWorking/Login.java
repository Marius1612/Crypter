package databaseWorking;

import utility.Constants;

import java.sql.*;

public class Login {

    public boolean LogIn(String user, String pass) {

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);

            stmt = conn.createStatement();
            String sql_res = "SELECT * FROM USERS WHERE username= '" + user + "'" + " AND password = '" + pass + "'";

            ResultSet rs = stmt.executeQuery(sql_res);
            System.out.println(rs.next());
            if(!(rs.getString(1)==null))
            {
                return true;
            }

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

        return false;
    }
}