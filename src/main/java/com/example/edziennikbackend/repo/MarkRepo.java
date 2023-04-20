package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Mark;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarkRepo extends JpaRepository<Mark, Long> {

    List<Mark> findAllByStudent(Student student);
    List<Mark> findAllByStudentAndTeacher(Student student, Teacher teacher);
    @Query(value = "SELECT * FROM dziennik.mark WHERE mark.teacher_id= :id", nativeQuery = true)
    List<Mark> findMarkByTeacherId(Long id);
}
