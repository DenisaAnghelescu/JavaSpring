package com.javabuc17.exampleProject.services;

import com.javabuc17.exampleProject.models.StudentModel;
import com.javabuc17.exampleProject.repositories.StudentRepository;
import com.javabuc17.exampleProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This annotation specifies that this class will be a Spring Bean, that will be injected
// elsewhere, whenever needed as a dependency
@Service     // ----> Spring Bean Class
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
        return studentRepository.save(student); //???
    }

    @Override
    public void deleteStudent(long id) {

    }
}
