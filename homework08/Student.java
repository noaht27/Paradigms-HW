// Noah Thompson
// 14 April 2026
// Student.java

public class Student extends UniversityMember{
    private String major;

    // constructor for student
    public Student(String name, String id, String email, String major){
        super(name, id, email);
        if (major == null) {
            throw new IllegalArgumentException("Major cannot be null");
        }
        this.major = major;
    }

    // abstract method from University Member
    @Override
    public String getRole(){
        return "Student";
    }

    // getMajor getter method
    public String getMajor(){
        return this.major;
    }

    @Override
    public String toString(){
        return getName() + "(" + getEmail() + ") - Major: " + getMajor();
    }
}