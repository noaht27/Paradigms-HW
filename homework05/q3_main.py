#!/usr/bin/env python3
# Noah Thompson
# 17 March 2026
# q3_main.py
from question3 import Student, Professor, TA, Course

if __name__ == '__main__':
    # create professor for Prof. Santos
    prof_Santos = Professor("Joanna Cecilia da Silva Santos", 12345, "jdasilv2@nd.edu", "CSE")

    # Create four ta objects for the four ta's
    ta_1 = TA("Ben Pable", 676767, "bpable@nd.edu")
    ta_1.assign_to_course("CSE30332")

    ta_2 = TA("Prince Noah Johnson", 4167, "pjohns24@nd.edu")
    ta_2.assign_to_course("CSE30332")

    ta_3 = TA("Robert Wallace", 1432, "rwallac1@nd.edu")
    ta_3.assign_to_course("CSE30332")

    ta_4 = TA("Tomas Sousa Pereira", 4521, "tsousape@nd.edu")
    ta_4.assign_to_course("CSE30332")

    # creating the course
    programming_paradigms = Course("Programming Paradigms", "CSE30332")
    programming_paradigms.add_instructor(prof_Santos) # adding instructor

    # creating 3 students
    student1 = Student("Noah Thompson", 2727, "nthomps7@nd.edu", "Computer Science")
    student2 = Student("James Bond", 700, "mrbond@nd.edu", "Computer Science")
    student3 = Student("Spiderman", 1967, "peterparker@nd.edu", "Computer Science")

    # adding students to course
    programming_paradigms.add_student(student1)
    programming_paradigms.add_student(student2)
    programming_paradigms.add_student(student3)

    # print outputs for views so i can see if it works!
    print(f"{prof_Santos}\n")
    
    print(ta_1)
    print(ta_2)
    print(ta_3)
    print(f"{ta_4}\n")

    print(student1)
    print(student2)
    print(student3)