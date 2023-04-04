package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.model.Grade;
import com.example.edziennikbackend.service.GradeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }


    @GetMapping("/grades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }
}
