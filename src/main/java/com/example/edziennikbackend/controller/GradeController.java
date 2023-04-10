package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.MarkDTO;
import com.example.edziennikbackend.dtos.TeacherDTO;
import com.example.edziennikbackend.model.Grade;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.Teacher;
import com.example.edziennikbackend.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

    private GradeService gradeService;
    private StudentService studentService;
    private UserService userService;

    private TeacherService teacherService;
    private MarkService markService;

    public GradeController(GradeService gradeService, StudentService studentService, UserService userService, TeacherService teacherService, MarkService markService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.userService = userService;
        this.teacherService = teacherService;
        this.markService = markService;
    }


    @GetMapping("/grades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping("/subjects/{username}")
    public List<TeacherDTO> getAllSubjectsByGrade(@PathVariable String username){
        Student student = studentService.findStudentByUser(userService.findUserByLogin(username));
        List<Teacher> teachers = student.getGrade().getTeachers();
        return teachers.stream()
               .map(teacher -> new TeacherDTO(teacher.getTeacherName(), teacher.getTeacherSurname(), teacher.getSubject(),
                       teacher.getMarks()
                               .stream()
                               .filter(mark -> mark.getStudent().equals(student))
                               .map(mark -> new MarkDTO(mark.getMarkNote(), mark.getMarkValue()))
                               .toList()
               ))
               .toList();
    }
}
