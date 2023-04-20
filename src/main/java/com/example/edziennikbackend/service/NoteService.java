package com.example.edziennikbackend.service;


import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.repo.NoteRepo;
import org.springframework.data.repository.query.Param;
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

    public void saveNote(Note note){
        noteRepo.save(note);
    }

    public void deleteNote(Long id){
        noteRepo.deleteById(id);
    }
    public List<Note> findNoteByTeacherId(Long id){
        return noteRepo.findNoteByTeacherId(id);
    }

}
