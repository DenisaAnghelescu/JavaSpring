package com.javabuc17.exampleProject.controllers;


import com.javabuc17.exampleProject.models.StudentModel;
import com.javabuc17.exampleProject.repositories.StudentRepository;
import com.javabuc17.exampleProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
// asta este un controller care va procesa/returna pagini web
public class WebController {


// | | | | | | | | \  \ \ \
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public WebController(StudentService studentService) {
        this.studentService = studentService;
    }
//private StudentRepository studentRepository;
//
//    @Autowired
//    public WebController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//| | | | | | | | | | | | | | |  |


    @GetMapping("/")  // URL pe care il pune clientul in browser
    public String getFromPage(){
        return "index";
    }

    @GetMapping("/student")  // URL pe care il pune clientul in browser
    public String getStudents(Model model){  //acest model se creeaza la folosirea metodei. variabilele definite in model vor fi afisate la view (desen)

        model.addAttribute("nume", "Andrei" );  // trimitem o variabila: nume = "Andrei"
                                                      // aici variabila va fi de tip String.
                                                      // acestea pot veni din DB

        StudentModel studentFromDB = studentService.getStudent(10);
        model.addAttribute("studentFromDB", studentFromDB);
        List<String> a = new ArrayList<>();
        a.add("Ghita");
        a.add("Vasile");
        a.add("Ion");
        model.addAttribute("listaMea",a);

        model.addAttribute("students",studentRepository.findAll());
        return "student";
    }

//    --------------------------------------o alta forma
    @GetMapping("/student1")
    public ModelAndView alternativeGetStudent(){
        ModelAndView modelAndView = new ModelAndView("student"); // the name of the view to render ??
        // cream un obiect
        modelAndView.addObject("nume", "Bobiță").setStatus(HttpStatus.OK);

//         obiect din DB
        StudentModel studentFromDB = studentService.getStudent(10);
        modelAndView.addObject("studentFromDB", studentFromDB);
        return modelAndView;
    }

}
