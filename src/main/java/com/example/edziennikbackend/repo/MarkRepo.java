package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Mark;
import com.example.edziennikbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarkRepo extends JpaRepository<Mark, Long> {

    List<Mark> findAllByStudent(Student student);
}
