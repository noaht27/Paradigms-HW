// Noah Thompson
// 14 April 2026
// Professor.java

public class Professor extends UniversityMember{
    private String department;

    // constructor for professor
    public Professor(String name, String id, String email, String department){
        super(name, id, email);
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
}