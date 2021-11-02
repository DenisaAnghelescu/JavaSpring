package com.javabuc17.demo.entities.student;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/")
    public String getFromPage() {

        return "index";
    }

    @GetMapping("/student")
    public String getStudents(Model model) {
        model.addAttribute("nume", "denisa");

        return "student";
    }

    @GetMapping("/student1")
    public ModelAndView getStudent1() {

        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("nume", "andrei");

        return modelAndView;
    }



}
