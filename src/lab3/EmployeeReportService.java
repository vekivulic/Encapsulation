package lab3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vekivulic
 */
public class EmployeeReportService {
    private String displayReport="";
    
    public void addDataToReport( String data){
        displayReport+=data;
    }
    
    public void printReport (){
        System.out.println(displayReport);
    }
    
    public void clearReport(){
        displayReport="";
    }
}
