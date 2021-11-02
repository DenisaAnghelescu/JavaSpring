package com.javabuc17.demo.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/student") //we defined this annotation, so we don't specify the path, over
// and over, at each mapping, on the method level
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // When we use @RequestParam, we will use a key-value-like notation, such as "id=1"
    // When we use @PathVariable, we must make sure we define the variable name in the path,
    // use the appropriate @PathVariable annotation. When the variable name is different, then
    // @PathVariable must also specify the actual name, which MUST be the same as in the path of the
    // @GetMapping
    @GetMapping
    public ResponseEntity<StudentModel> getStudent(@RequestParam long id) { // Query parameter
        StudentModel student = studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel student) {
        return ResponseEntity.ok(student); // this will do the exact same thing as in the getStudent return
    }

    @PutMapping
    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel student) {
        StudentModel updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    } // An example url would look like this:
    // serverAddress (such as localhost):port/student/1/Laurentiu?lastName=Cucubau @DeleteMapping(path = "/{id}/{firstName}")
    // This will be concatenated to the already specified path public ResponseEntity<Void> deleteStudent(@PathVariable long id, @PathVariable("firstName") String numaleMic){ studentService.deleteStudent(id); return ResponseEntity.status(HttpStatus.OK).build();
}
