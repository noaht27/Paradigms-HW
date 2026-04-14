// Noah Thompson
// 14 April 2026
// Student.java

public class TA extends UniversityMember{
    private Course[] coursesAssisting = new Course[2];
    private int index = 0;

        // constructor for TA
        public TA(String name, String id, String email){
            super(name, id, email);
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
}