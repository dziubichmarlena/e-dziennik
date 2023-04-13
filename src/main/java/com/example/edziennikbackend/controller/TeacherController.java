package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.TeacherDTO;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class TeacherController {

    private StudentService studentService;

    private UserService userService;


    @GetMapping("/teachers")
    public List<TeacherDTO> getAllStudentTeachers(@AuthenticationPrincipal User user){
        return studentService.findStudentByUser(userService.findUserByLogin(user.getLogin())).getGrade().getTeachers().stream()
                .map(teacher -> new TeacherDTO(teacher.getTeacherName(), teacher.getTeacherSurname(),
                        teacher.getTelephone(), teacher.getClassroom(), teacher.getTeacherInfo()))
                .toList();
    }
}
