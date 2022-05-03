package telemedproject;

import java.sql.*;

public final class AddDoctor {

    private int Doctorid;
    private String doctorName ,Hospital, Specialty;
  

    void doAdd() {
        //Check if username or password supplied
        if (Doctorid >0 || doctorName!=null || Hospital != null || Specialty!=null ) {
   
            try {
                //Instantiate DbConnection class to use the connection
                DbConnectionTelemed stayconnected = new DbConnectionTelemed();
                stayconnected.getConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the statement
                stmt.executeUpdate("INSERT INTO doctors VALUES('" + Doctorid + "','" + doctorName + "','" + Hospital +"','" + Specialty + "')");
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
        this.Doctorid = Doctorid;
        this.doctorName = doctorName;
        this.Hospital = Hospital;
        this.Specialty = Specialty;
        
        doAdd();
    }

}
