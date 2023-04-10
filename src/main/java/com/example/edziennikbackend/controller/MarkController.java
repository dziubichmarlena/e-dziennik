package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.model.Mark;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.service.MarkService;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarkController {

    private MarkService markService;
    private StudentService studentService;

    private UserService userService;

    public MarkController(MarkService markService, StudentService studentService, UserService userService) {
        this.markService = markService;
        this.studentService = studentService;
        this.userService = userService;
    }

    @GetMapping("/marks/{login}")
    public List<Mark> getAllMarksByLoggedStudent(@PathVariable String login) {
        System.out.println(login);
        Student student = studentService.findStudentByUser(userService.findUserByLogin(login));
        return markService.findAllMarksByStudent(student);
    }


}
