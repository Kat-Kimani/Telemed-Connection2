/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telemedproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class SelectDoctor {
      private int Doctorid;
    private String doctorName ,Hospital, Specialty;
  

    void doSelect() {
        //Check if username or password supplied
        if (Doctorid >0 || doctorName!=null || Hospital != null || Specialty!=null ) {
   
            try {
                //Instantiate DbConnection class to use the connection
                DbConnectionTelemed stayconnected = new DbConnectionTelemed();
                stayconnected.getConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the statement
          
                 ResultSet rs = stmt.executeQuery("SELECT * FROM doctors");
            //Handle the results set
            System.out.format("%s, %s\n", "Doctorid" ,"doctorName" ,"Hospital", "Specialty");
            while (rs.next()) {
                //System.out.println("Doctorid" +"doctorName" + "Hospital" + "Specialty);
                System.out.format("%s, %s\n", rs.getString("Doctorid"), rs.getInt("doctorName"),rs.getInt("Hospital"),rs.getInt("Specialty"));
            }  
        
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
        this.Doctorid = Doctorid;
        this.doctorName = doctorName;
        this.Hospital = Hospital;
        this.Specialty = Specialty;
        
        doSelect();
    }  
}
