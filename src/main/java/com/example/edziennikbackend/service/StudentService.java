package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.repo.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student findStudentByUser(User user){
        return studentRepo.findStudentByUser(user);
    }

}
