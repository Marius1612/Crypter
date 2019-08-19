package databaseWorking;

import utility.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddDataInDataBase {


        public void addData(String username, String password) {
            Connection conn = null;
            Statement stmt = null;
            try{
                Class.forName(Constants.JDBC_DRIVER);

                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                System.out.println("Connected database successfully...");

                System.out.println("Inserting records into the table...");
                stmt = conn.createStatement();

                String sql = String.format("INSERT INTO USERS VALUES ( '%s', '%s')", username, password);
                stmt.executeUpdate(sql);

                System.out.println("Inserted records into the table...");

            } catch(Exception se){
                se.printStackTrace();
            } finally{
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException ignored){
                }
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }
    }

