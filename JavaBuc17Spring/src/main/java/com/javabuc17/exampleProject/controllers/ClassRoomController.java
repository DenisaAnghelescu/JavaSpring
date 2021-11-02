package com.javabuc17.exampleProject.controllers;

import com.javabuc17.exampleProject.models.ClassRoomModel;
import com.javabuc17.exampleProject.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/classRoom")
public class ClassRoomController {

    private ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping
    public ResponseEntity<ClassRoomModel> addClassRoom(@RequestBody ClassRoomModel classRoom){
        ClassRoomModel addedClass = classRoomService.addClassRoom(classRoom);
        return ResponseEntity.status(HttpStatus.OK).body(addedClass);
    }

    @GetMapping
    public ResponseEntity<ClassRoomModel> getClassRoom(@RequestParam int id){
        ClassRoomModel requestedClass = classRoomService.getClassRoom(id);
        return ResponseEntity.status(200).body(requestedClass);
    }

    @PutMapping
    public ResponseEntity<ClassRoomModel> updateClassRoom(@RequestBody ClassRoomModel classRoom){
        ClassRoomModel updatedClassRoom = classRoomService.updateClassRoom(classRoom);
        return ResponseEntity.ok(updatedClassRoom);
    }

//    @DeleteMapping(path = "")
//    public ResponseEntity<Void> deleteStudent(@PathVariable long id, @PathVariable("firstName") String numaleMic, @RequestParam String lastName){
//          studentService.deleteStudent(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
