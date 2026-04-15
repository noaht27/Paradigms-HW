// Noah Thompson
// 14 April 2026
// Professor.java

public class Professor extends UniversityMember{
    private String department;

    // constructor for professor
    public Professor(String name, String id, String email, String department){
        super(name, id, email);
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        this.department = department;
    }
    
    // abstract method from University Member
    @Override
    public String getRole(){
        return "Professor";
    }
    
    // getDepartment getter method
    public String getDepartment(){
        return this.department;
    }

    // override toString to get human readable string representation of object
    @Override
    public String toString(){
        String fullName = getName();
        // looked this up as a way to get only the last name, use lastIndexOf " " for the space between first and last name
        String lastName = fullName.substring(fullName.lastIndexOf(" ") + 1);
        return "Prof. " + lastName + "(" + getEmail() + ")";
    }
}