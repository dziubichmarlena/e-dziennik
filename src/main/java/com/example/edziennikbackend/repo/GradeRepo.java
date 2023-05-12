package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {

    List<Grade> findAll();
    @Query(value = "SELECT grade_id FROM dziennik.grades_teachers WHERE grades_teachers.teacher_id = :teacher_id", nativeQuery = true)
    List<Long> findGradesIdByTeacherId(@Param("teacher_id") Long teacher_id);
    @Query(value ="SELECT * FROM dziennik.grade WHERE grade.id IN :ids",nativeQuery = true)
    List<Grade> findGradeById(@Param("ids") List<Long> ids);
}
