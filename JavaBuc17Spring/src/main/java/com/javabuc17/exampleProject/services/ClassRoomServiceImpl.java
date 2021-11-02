package com.javabuc17.exampleProject.services;

import com.javabuc17.exampleProject.models.ClassRoomModel;
import com.javabuc17.exampleProject.repositories.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")   --> intantiaza la fiecare injectie (@Autowired)
// by default --> injectiile sunt Singleton. Instantiat la prima injectie
public class ClassRoomServiceImpl implements ClassRoomService{

    private ClassRoomRepository classRoomRepository;
//    private ClassRoomRepository classRoomRepository1;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public ClassRoomModel addClassRoom(ClassRoomModel classRoom) {
        return classRoomRepository.saveAndFlush(classRoom);
    }

    @Override
    public ClassRoomModel updateClassRoom(ClassRoomModel classRoom) {
        return null;
    }

    @Override
    public ClassRoomModel getClassRoom(int id) {
        return classRoomRepository.getOne(id);
    }

    @Override
    public void deleteClassRoom(int id) {

    }
}
