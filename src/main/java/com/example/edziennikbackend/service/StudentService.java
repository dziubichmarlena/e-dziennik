package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student findStudentByLogin(String login){
        return studentRepo.findStudentByLogin(login);
    }
}
