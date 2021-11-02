package com.javabuc17.exampleProject.controllers;

import com.javabuc17.exampleProject.models.StudentModel;
import com.javabuc17.exampleProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// This annotation specifies that this class will be a Spring Bean, that will be injected
// elsewhere, whenever needed as a dependency
//---> Spring Bean Class
@RestController  // inversion of control
// pentru informatii json

//@Controller  --> pentru html de ex


//pentru a putea fia accesata de Spring Boot   -> din pom.xml -> dependinta spring-boot-starter-web
// acesta este un inversion of control -> SpringBoot detine controlul prin @RestController
@RequestMapping(path = "/rest/student")
// /rest/student pentru ca este un conflict la WebController


public class StudentController {

    @Autowired
    private StudentService studentService; //interface
//     -> este implementata de Spring Boot prin StudentServiceImpl
//    Daca avem o a 2-a clasa StudentServiceImpl2, SpringBoot nu va sti prin ce clasa sa instantieze. (trebuie sa-i spunem noi cu @Bean)

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // When we use @RequestParam, we will use a key-value-like notation, such as "id=1"
    // When we use @PathVariable, we must make sure we define the variable name in the path,
    // use the appropriate @PathVariable annotation. When the variable name is different, then
    // @PathVariable must also specify the actual name, which MUST be the same as in the path of the
    // @GetMapping


//    @GetMapping(path = "/Student/{id}")
//      @GetMapping(path = "/{id}")    //

    @GetMapping  // specificam ca metoda exte expusa pentru a face apeluri de tip GET
//    public ResponseEntity<StudentModel> getStudent(@PathVariable("id") long numar){
    public ResponseEntity<StudentModel> getStudent(@RequestParam long id) {    //Query parameter   ......?id=ajhscbas
        StudentModel student = studentService.getStudent(id);   // aducem un student prin interfata, DIN Service layer
        return ResponseEntity.status(HttpStatus.OK).body(student);    //sau return ResponseEntity.status(200).body(null);
    }

    @PostMapping
    public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel student) {
        System.out.println(student.getName() + " " + student.getLastName());  // getName() este folosit prin lombok (File->settings->Plugins-> install lombok + enable)

        StudentModel addedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(addedStudent);                       // ex 2
    }

    @PutMapping
    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel student) {
        StudentModel updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // An example url would look like this:
    // http://serverAddress (such as localhost):port/student/1/Laurentiu?lastName=Cucubau

    @DeleteMapping(path = "/{id}/{firstName}") // This will be concatenated to the already specified path
    public ResponseEntity<Void> deleteStudent(@PathVariable long id, @PathVariable("firstName") String numaleMic) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).build();


        // Because we are not returning anything in
        // the response body, we will specify the T of ResponseEntity to be of type Void
        // hence why, we are also returning the relevant NO_CONTENT status
    }
}
