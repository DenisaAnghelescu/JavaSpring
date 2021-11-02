package com.javabuc17.exampleProject.services;

import com.javabuc17.exampleProject.models.ClassRoomModel;

public interface ClassRoomService {

    ClassRoomModel addClassRoom(ClassRoomModel classRoom);
    ClassRoomModel updateClassRoom(ClassRoomModel classRoom);
    ClassRoomModel getClassRoom(int id);
    void deleteClassRoom(int id);
}
