package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Grade;
import com.example.edziennikbackend.model.Teacher;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.repo.GradeRepo;
import com.example.edziennikbackend.repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepo teacherRepo;
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Teacher findTeacherByUser(User user){
        return teacherRepo.findTeacherByUser(user);
    }
}
