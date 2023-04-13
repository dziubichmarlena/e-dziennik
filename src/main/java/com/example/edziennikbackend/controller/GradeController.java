package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.model.Grade;
import com.example.edziennikbackend.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class GradeController {

    private GradeService gradeService;
    private StudentService studentService;
    private UserService userService;

    private TeacherService teacherService;
    private MarkService markService;


    @GetMapping("/grades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }


}
