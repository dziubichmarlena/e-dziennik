package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.repo.NoteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public List<Note> findAllNotesByStudent(Student student){
        return noteRepo.findAllByStudent(student);
    }
}
