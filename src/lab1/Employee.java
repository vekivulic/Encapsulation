package lab1;

import java.util.Date;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a 
 * constructor to enforce that. Review the tips in the document 
 * "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    public final String COMPANY_NAME="Acme"; // it can not be change, no danger 
    //to making public access, no risk to making it public 
    //public getters and setters unless you want to have read only propertis 
    //if you leave setter off cant change it, 
    // if you leave setter out no change 
    
    
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private  boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;
    
    //Single responsbility method 
    
    public String getAnnualWages(){
        return firstName+ lastName;
    }
 
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length()<2) {
            System.out.println("cube id is required");
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            System.out.println("last name is required");
            return;
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        
        
        return ssn;
    }

    public void setSsn(String ssn) {
        if(ssn==null || ssn.length()<9 || ssn.length()>9){
            System.out.println("");
        return;
        }
        this.ssn = ssn;
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

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
        if(cubeId == null || cubeId.isEmpty()) {
            System.out.println("cube id is required");
        }
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        if(cubeId == null || cubeId.isEmpty()) {
            System.out.println("cube id is required");
        }
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        if(orientationDate==null)
        this.orientationDate = orientationDate;
    }



}
