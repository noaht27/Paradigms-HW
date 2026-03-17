#!/usr/bin/env python3
# Noah Thompson
# 17 March 2026
# question3.py
from abc import ABC, abstractmethod

class UniversityMember(ABC):
    # static attribute for number of members
    num_members = 0

    # constructor for name, member id and email
    def __init__(self, name, member_id, email):
        self.name = name
        self.member_id = member_id
        self.email = email
        #super().__init__()

        UniversityMember.num_members += 1

    # abstract method returning role of the member
    @abstractmethod
    def get_role(self):
        pass

# concrete classes that inherit from university member
class Student(UniversityMember):
    # student specifies a major
    def __init__(self, name, member_id, email, major):
        super().__init__(name, member_id, email)
        self.major = major

    def get_role(self):
        return "Student"
    
    #special str method based on format given in hw5
    def __str__(self):
        return (f"{self.name} ({self.email}) - Major: {self.major}")

class Professor(UniversityMember):
    #professor specifies a department
    def __init__(self, name, member_id, email, department):
        super().__init__(name, member_id, email)
        self.department = department

    def get_role(self):
        return "Professor"
    
    #special str method that gives human string representation of object
    def __str__(self):
        last_name = self.name.split()[-1]
        return (f"Prof. {last_name} ({self.email})")

class TA(UniversityMember):
    # TA needs courses assisting
    def __init__(self, name, member_id, email):
        super().__init__(name, member_id, email)
        self.courses_assisting = []

    def get_role(self):
        return "TA"
    
    # method takes input a course and adds to courses_assisting
    def assign_to_course(self, course):
        if course not in self.courses_assisting:
            self.courses_assisting.append(course)
    
    # special string method for TA with courses taught also listed and comma seperated
    def __str__(self):
        courses_taught = ", ".join(course for course in self.courses_assisting)
        return (f"{self.name} ({self.email}). TA for Courses: {courses_taught}.")

# course class with name code, enrolled students and instructor
class Course:
    def __init__(self, name, code):
        self.name = name
        self.code = code
        self.enrolled_students = [] # use add_student method for this
        self.instructor = None # use add_instructor method for this
    
    def add_student(self, student):
        if student not in self.enrolled_students:
            self.enrolled_students.append(student)

    def remove_student(self, student):
        if student in self.enrolled_students:
            self.enrolled_students.remove(student)

    def add_instructor(self, professor):
        self.instructor = professor

    def remove_instroctor(self):
        self.instructor = None
    
