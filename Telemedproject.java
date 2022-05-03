/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telemedproject;

/**
 *
 * @author User
 */
public class Telemedproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Doctorid = 1;
        String doctorName = "Kat Kimani";
        String Hospital= "AAR";
        String Specialty= " Gynae";
        
        AddDoctor myDoctor = new AddDoctor();              
        myDoctor.setDoctorDetails(Doctorid, doctorName, Hospital, Specialty);

// TODO code application logic here
    }

}
