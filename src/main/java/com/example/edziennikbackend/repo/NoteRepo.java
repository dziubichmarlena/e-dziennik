package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

    List<Note> findAllByStudent(Student student);
    @Query(value ="SELECT * FROM dziennik.note WHERE note.teacher_id= :id", nativeQuery = true)
    List<Note> findNoteByTeacherId(@Param("id") Long id);
}
