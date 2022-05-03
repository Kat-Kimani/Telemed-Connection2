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
public class UpdateDoctor {
        private int Doctorid;
    private String doctorName ,Hospital, Specialty;
  

    void doUpdate() {
        //Check if username or password supplied
        if (Doctorid >0 || doctorName!=null || Hospital != null || Specialty!=null ) {
   
            try {
                //Instantiate DbConnection class to use the connection
                DbConnectionTelemed stayconnected = new DbConnectionTelemed();
                stayconnected.getConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the statement
                stmt.executeUpdate("UPDATE doctors SET hospital = '" + Hospital + "'WHERE Doctorid ='"+Doctorid+"'");
                System.out.println("Doctor details added successfully \n");
             
//Close the connection
                stayconnected.con.close();
            } catch (SQLException e) {
                System.out.println("Error! See below details \n");
                System.out.println(e);
            }
        } else {
            System.out.println("Doctor Details can not be blank");
        }
    }

    public void setDoctorDetails(int Doctorid, String doctorName,String Hospital, String Specialty ) {
        this.Hospital = Hospital;
   
        doUpdate();
    }
}
