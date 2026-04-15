// Noah Thompson
// 14 April 2026
// Main.java
public class Main{
    public static void main(String[] args){
        // Create objects to represent our course programming paradigms
        Professor prof = new Professor("Professor Santos", "12345", "jdasilv2@nd.edu", "CSE");
        TA ben = new TA("Ben Pable", "67", "bpable@nd.edu");
        TA robert = new TA("Robert Wallace", "100", "rwallac1@nd.edu");
        TA tomas = new TA("Tomas Sousa Pereira ", "150", "tsousape@nd.edu");
        TA Prince = new TA("Prince Noah Johnson", "125", "pjohns24@nd.edu");
        Course paradigms = new Course("Programming Paradigms", "CSE30332", prof);
        
        // assigning TA's to the course
        ben.assignToCourse(paradigms);
        robert.assignToCourse(paradigms);
        tomas.assignToCourse(paradigms);
        Prince.assignToCourse(paradigms);

        // create another course object with a diff prof and one TA
        Professor Theisen = new Professor("Bill Theisen", "676767", "wtheisen@nd.edu", "CSE");
        TA tom = new TA("Tom", "12345", "tom@nd.edu");
        Course ai = new Course("Intro to AI", "CSE 30124", Theisen);
        tom.assignToCourse(ai);

        // create 3 students
        Student noah = new Student("Noah Thompson", "9022101234", "nthomps7@nd.edu", "Computer Science");
        Student andre = new Student("Andre Maynard", "9022101777", "amaynard@nd.edu", "Computer Science");
        Student druski = new Student("Druski", "42067", "druski@gmail.com", "Art");

        // add these 3 students to both courses
        paradigms.addStudent(druski);
        paradigms.addStudent(noah);
        paradigms.addStudent(andre);

        ai.addStudent(druski);
        ai.addStudent(andre);
        ai.addStudent(noah);
    }
}