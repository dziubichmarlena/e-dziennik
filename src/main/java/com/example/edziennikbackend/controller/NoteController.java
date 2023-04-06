package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.NoteDTO;
import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.service.NoteService;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    private NoteService noteService;
    private StudentService studentService;
    private UserService userService;

    public NoteController(NoteService noteService, StudentService studentService, UserService userService) {
        this.noteService = noteService;
        this.studentService = studentService;
        this.userService = userService;
    }

    @GetMapping("/notes/{login}")
    public List<NoteDTO> getAllStudentNotes(@PathVariable String login) {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<Note> notes = noteService.findAllNotesByStudent(studentService.findStudentByUser(userService.findUserByLogin(login)));
        return notes.stream()
                .map(note -> new NoteDTO(note.getTeacher().getTeacherName() + " " + note.getTeacher().getTeacherSurname(),
                        note.getNoteContent(), note.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .toList();
    }
}
