package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.MarkDTO;
import com.example.edziennikbackend.dtos.TeacherDTO;
import com.example.edziennikbackend.model.Mark;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.Teacher;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.MarkService;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.TeacherService;
import com.example.edziennikbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class MarkController {

    private MarkService markService;
    private StudentService studentService;

    private UserService userService;
    private TeacherService teacherService;


    @GetMapping("/marks/{login}")
    public List<Mark> getAllMarksByLoggedStudent(@PathVariable String login) {
        System.out.println(login);
        Student student = studentService.findStudentByUser(userService.findUserByLogin(login));
        return markService.findAllMarksByStudent(student);
    }

    @GetMapping("/subjects/marks/{username}")
    public List<TeacherDTO> getAllSubjectsByGrade(@PathVariable String username){
        Student student = studentService.findStudentByUser(userService.findUserByLogin(username));
        List<Teacher> teachers = student.getGrade().getTeachers();
        return teachers.stream()
                .map(teacher -> new TeacherDTO(teacher.getSubject(),
                        teacher.getMarks()
                                .stream()
                                .filter(mark -> mark.getStudent().equals(student))
                                .map(mark -> new MarkDTO(mark.getMarkNote(), mark.getMarkValue()))
                                .toList()
                ))
                .toList();
    }

    @PostMapping("/subject/mark/{username}")
    public void saveMark(@AuthenticationPrincipal User user, @PathVariable String username, @RequestBody Mark mark){
        Student student = studentService.findStudentByUser(userService.findUserByLogin(username));
        Teacher teacher = teacherService.findTeacherByUser(user);
        mark.setTeacher(teacher);
        mark.setStudent(student);
        markService.saveMark(mark);
    }


}
