package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Teacher;
import com.example.edziennikbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Teacher findTeacherByUser(User user);
}
