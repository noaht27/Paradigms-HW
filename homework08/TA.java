// Noah Thompson
// 14 April 2026
// Student.java

public class TA extends UniversityMember{
    private Course[] coursesAssisting;
    private int index = 0;

    // constructor for TA
    public TA(String name, String id, String email){
        super(name, id, email);
        this.coursesAssisting = new Course[2];
    }
    
    // abstract method from University Member
    @Override
    public String getRole(){
        return "TA";
    }

    // assign to course function
    public void assignToCourse(Course c){
        // cant have more than 2 courses
        if (index >= 2){
            return;
        }

        // if no courses yet
        if (index == 0){
            coursesAssisting[index] = c;
            index +=1;
        }
        // if one course make sure not the same as the previous
        else if (index == 1){
            if (coursesAssisting[0] != c){
                coursesAssisting[index] = c;
                index +=1;
            }
        }
            
    }
    
    // getCoursesAssisting getter method
    public Course[] getCoursesAssisting(){
        return this.coursesAssisting;
    }

    // override toString to get human readable string representation of object
    @Override
    public String toString(){
        String[] coursecodes = new String[this.index];

        // have to get individual course codes
        for (int i = 0; i < this.index; i++){
            coursecodes[i] = coursesAssisting[i].getCode();
        }

        //course codes need to be comma separated
        String joined = String.join(", ", coursecodes);

        return getName() + " (" + getEmail() + "). TA for Courses: "+ joined;
    }
}