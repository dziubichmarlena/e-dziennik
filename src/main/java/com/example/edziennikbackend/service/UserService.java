package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.repo.StudentRepo;
import com.example.edziennikbackend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    private StudentRepo studentRepo;

    public UserService(UserRepo userRepo, StudentRepo studentRepo) {
        this.userRepo = userRepo;
        this.studentRepo = studentRepo;
        /*Student student = new Student();
        student.setLogin("student");
        student.setPassword("haslo");
        student.setRole("ROLE_USER");
        studentRepo.save(student);*/
    }

    public List<User> getAllStudents(){
        return userRepo.findAll();
    }

    public User findStudentByLogin(String login){
        return userRepo.findUserByLogin(login);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }
}
