/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telemedproject;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DeleteDoctor {
      private int Doctorid;
    private String doctorName ,Hospital, Specialty;
  

    void doDelete() {
        //Check if username or password supplied
        if (Doctorid >0 || doctorName!=null || Hospital != null || Specialty!=null ) {
   
            try {
                //Instantiate DbConnection class to use the connection
                DbConnectionTelemed stayconnected = new DbConnectionTelemed();
                stayconnected.getConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the statement
                stmt.executeUpdate("Delete FROM doctors WHERE  Doctorid ='" + Doctorid + "'");
                System.out.println("Doctor details deleted successfully \n");
                //Close the connection
                stayconnected.con.close();
            } catch (SQLException e) {
                System.out.println("Error! See error details below \n");
                System.out.println(e);
            }
        } else {
            System.out.println("You must select doctor details to delete");
        }
    }

    public void setDoctorDetails(int Doctorid ) {
        this.Doctorid = Doctorid;
   
        doDelete();
    }  
}
