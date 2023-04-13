package com.example.edziennikbackend.controller;


import com.example.edziennikbackend.dtos.NoteDTO;
import com.example.edziennikbackend.model.Note;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.model.Teacher;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.NoteService;
import com.example.edziennikbackend.service.StudentService;
import com.example.edziennikbackend.service.TeacherService;
import com.example.edziennikbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;
    private StudentService studentService;
    private UserService userService;

    private TeacherService teacherService;


    @GetMapping("/notes")
    public List<NoteDTO> getAllStudentNotes(@AuthenticationPrincipal User user) {
        List<Note> notes = noteService.findAllNotesByStudent(studentService.findStudentByUser(userService.findUserByLogin(user.getLogin())));
        return notes.stream()
                .map(note -> new NoteDTO(note.getTeacher().getTeacherName() + " " + note.getTeacher().getTeacherSurname(),
                        note.getNoteContent(), note.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), note.isKindOfNote()))
                .toList();
    }

    @PostMapping("/note/{usernameTeacher}/{usernameStudent}")
    public void addNote(@PathVariable("usernameTeacher") String usernameTeacher, @PathVariable("usernameStudent") String usernameStudent, @RequestBody Note note){
        Teacher teacher = teacherService.findTeacherByUser(userService.findUserByLogin(usernameTeacher));
        Student student = studentService.findStudentByUser(userService.findUserByLogin(usernameStudent));
        note.setTeacher(teacher);
        note.setStudent(student);
        noteService.saveNote(note);
    }

}
