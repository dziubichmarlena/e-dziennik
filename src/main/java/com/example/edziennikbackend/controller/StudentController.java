package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.StudentDTO;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private UserService userService;

    private StudentService studentService;

    public StudentController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<User> getAllStudents() {
        return userService.getAllUsers();
    }

    @GetMapping("/students/grade/{grade_Id}")
    List<StudentDTO> findStudentByGrade_Id(@PathVariable Long grade_Id){
        List<Student> students = studentService.findStudentByGrade_Id(grade_Id);
        return students.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

        @GetMapping("/student")
    public List<Student> getAllStudents_2() {
        return studentService.findAllStudents();
    }


}
