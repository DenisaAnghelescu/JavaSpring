package com.javabuc17.demo.entities.student;

public interface StudentService {

    StudentModel getStudent(long id);

    StudentModel addStudent(StudentModel student);

    StudentModel updateStudent(StudentModel student);

    void deleteStudent(long id);
}
