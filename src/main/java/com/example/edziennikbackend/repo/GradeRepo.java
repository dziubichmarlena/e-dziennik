package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {

    List<Grade> findAll();
}
