package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private UserService userService;

    public StudentController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/students")
    public List<User> getAllStudents() {
        return userService.getAllUsers();
    }

}
