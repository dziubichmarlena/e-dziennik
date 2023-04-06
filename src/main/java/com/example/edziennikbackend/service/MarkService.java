package com.example.edziennikbackend.service;

import com.example.edziennikbackend.model.Mark;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.repo.MarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    private MarkRepo markRepo;

    public MarkService(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }


    public List<Mark> findAllMarksByStudent(Student student){
        return markRepo.findAllByStudent(student);
    }
}