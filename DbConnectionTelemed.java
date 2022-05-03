
package telemedproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionTelemed {
  Connection con;
    Connection getConnection() throws SQLException {
        //Use try {...}catch(Exception e){} to test for any DB connection errors
        try {
            //STEP 1: Load the mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 2: Create the connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemeddb", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed. See error below.");
            System.out.println(e);
        }
        return con;
    }  
}
