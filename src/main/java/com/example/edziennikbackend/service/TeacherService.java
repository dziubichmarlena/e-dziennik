package com.example.edziennikbackend.service;


import com.example.edziennikbackend.repo.TeacherRepo;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

}
