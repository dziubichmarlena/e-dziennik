package com.example.edziennikbackend.repo;

import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

    List<Note> findAllByStudent(Student student);
}
