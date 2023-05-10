package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Grade;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student findStudentByUser(User user){
        return studentRepo.findStudentByUser(user);
    }

    public Student findStudentById(Long id){
        return studentRepo.findById(id).orElseThrow();
    }

    public List<Student> findStudentByGrade_Id(Long gradeId) {
        return studentRepo.findStudentByGrade_Id(gradeId);
    }


    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }
}
