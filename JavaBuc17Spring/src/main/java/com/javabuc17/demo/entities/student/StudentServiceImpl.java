package com.javabuc17.demo.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentModel getStudent(long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return null;
    }

    @Override
    public void deleteStudent(long id) {

    }
}
