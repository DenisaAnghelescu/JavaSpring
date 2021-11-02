package com.javabuc17.exampleProject.services;


import com.javabuc17.exampleProject.models.StudentModel;

public interface StudentService{ //care este modelul si ce  tip de date are ID-ul

    StudentModel getStudent(long id);

    StudentModel addStudent(StudentModel student);

    StudentModel updateStudent(StudentModel student);

    void deleteStudent(long id);
}
