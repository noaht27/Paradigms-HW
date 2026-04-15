// Noah Thompson
// 14 April 2026
// Course.java

public class Course{
    private String name;
    private String code;
    private Student[] enrolledStudents;
    private Professor instructor;

    public Course(String name, String code, Professor instructor){
        // if any parameter is null must throw a runtime error
        if (name == null){
            throw new IllegalArgumentException("Course name not given");
        }
        this.name = name;

        // checking course code
        if (code == null){
            throw new IllegalArgumentException("Course code not given");
        }
        this.code = code;

        //checking instructor
        if (instructor == null){
            throw new IllegalArgumentException("Course instructor not given");
        }
        this.instructor = instructor;

        // "initialize the attribute enrolledStudents as an array with 50 elements"
        this.enrolledStudents = new Student[50];
    }

    public void addStudent(Student s){
        if (s == null){
            throw new IllegalArgumentException("Cannot add null Student");
        }
        // add new student to array
        for (int i = 0; i < enrolledStudents.length; i++){
            if (enrolledStudents[i] == null){
                enrolledStudents[i] = s;
                return;
            }
        }
    }

    public void removeStudent(Student s){
        if (s == null){
            throw new IllegalArgumentException("Cannot remove null Student");
        }

        // need to remove student
        for (int i = 0; i < enrolledStudents.length; i++){
            if (enrolledStudents[i] == s){
                // delete student
                enrolledStudents[i] = null;
                return;
            }
        }
    }

    //name getter method
    public String getName(){
        return this.name;
    }

    //code getter
    public String getCode(){
        return this.code;
    }

    // instructor getter
    public Professor getInstructor(){
        return this.instructor;
    }

    // enrolledStudents getter
    public Student[] getEnrolledStudents(){
        return this.enrolledStudents;
    }
}