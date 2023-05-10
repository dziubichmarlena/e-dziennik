package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findStudentByUser(User user);
    @Query(value = "SELECT * FROM dziennik.student WHERE student.grade_id = :gradeId", nativeQuery = true)
    List<Student> findStudentByGrade_Id(@Param("gradeId") Long gradeId);
}
