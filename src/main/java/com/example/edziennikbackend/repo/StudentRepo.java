package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findStudentByLogin(String login);
}
