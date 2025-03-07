package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${favouriteSystems}")
    private List<String> favouriteSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // Create a student object
        Student student = new Student();

        //Add student object to model
        theModel.addAttribute("student", student);

        // Add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // Add the list of languages to the model
        theModel.addAttribute("languages", languages);

        // Add the list of languages to the model
        theModel.addAttribute("languages", languages);

        // Add the list of operating systems to the model
        theModel.addAttribute("favouriteSystems", favouriteSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() +
                " " + theStudent.getLastName());

        return "student-confirmation";
    }

}
