package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;
import lab4.solution.EmployeeReportService;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee { 
    // Use constants for numbers or Strings that a repeated 
    // (all are called 'magic numbers', which are evil)
    
   
    
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;
    private EmployeeReportService reportService;

    /*
        Notice we force certain mandatory properties by using a custom
        constructor. But we use the setter method to peform validation.
    */
    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        reportService = new EmployeeReportService();
    }
    
    /* 
        This should be private because it is useful only to this class and then,
        only as a helper method to other methods. This is method hiding - a type 
        of encapsulation where we put frequently used code in one place for for
        easy editing later if necessary.
    */
    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(orientationDate);
    }
    
    /*
        This method is public because it must be available to other classes in
        this project. Notice that it controls the order in which the helper methods
        are called. Order isn't always an issue, but here it obviously is, which
        may be an important requirement.
    */
    // cubeID id must be passed and come in from somewhere 
    public void doFirstTimeOrientation(String cubeId) {
        orientationDate = new Date();
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }
    
    // The following methods may be public or private, depending on whether
    // they need to be called from other classes independently.

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        reportService.addData(firstName + " " + lastName + " met with Hr on "
            + getFormattedDate() );
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        reportService.addData(firstName + " " + lastName + " met with Dept. Staff on "
            + getFormattedDate());
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        reportService.addData(firstName + " " + lastName + " reviewed Dept policies on "
            + getFormattedDate());
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        if(cubeId==null || cubeId.isEmpty()){
            System.out.println("Error");
        }else{
        this.cubeId = cubeId;
        this.movedIn = true;
        
        }

        reportService.addData(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + getFormattedDate());
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation. Throwing ane exception is the best
    // practice when validation fails. Don't do a System.out.println()
    // to display an error message -- not the job of this class!
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) {
            System.out.println("First Name required");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            System.out.println("Last Name is required");
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if(ssn == null || ssn.length() < 9 || ssn.length() > 11) {
            System.out.println( "Social Security and must be between 9 and 11 characters (if hyphens are used)");
        }
        this.ssn = ssn;
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    
    public void setCubeId(String cubeId) {
        if(cubeId == null || cubeId.isEmpty()) {
            System.out.println("Cude ID is required");
        }
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        if(orientationDate == null) {
            System.out.println("Required Date");
        }
        this.orientationDate = orientationDate;
    }

    public EmployeeReportService getReportService() {
        return reportService;
    }

    public void setReportService(EmployeeReportService reportService) {
        this.reportService = reportService;
    }
    
}