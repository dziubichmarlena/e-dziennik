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

    @PostMapping("/note/{id}")
    public void saveNote(@AuthenticationPrincipal User user, @PathVariable("id") Long id, @RequestBody Note note){
        Teacher teacher = teacherService.findTeacherByUser(user);
        Student student = studentService.findStudentById(id);
        note.setTeacher(teacher);
        note.setStudent(student);
        noteService.saveNote(note);
    }
    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
    }
    @GetMapping("note/teacher")
    public List <NoteDTO> getAllTeachersNote(@AuthenticationPrincipal User user){
        Teacher teacher = teacherService.findTeacherByUser(user);
        List<Note> notes = noteService.findNoteByTeacherId(teacher.getId());
        return  notes.stream()
                .map(note ->new NoteDTO(
                        note.getId(),
                        note.getTeacher().getTeacherName()+" "+ note.getTeacher().getTeacherSurname(),
                        note.getStudent().getStudentName()+" " + note.getStudent().getStudentSurname(),
                        note.getNoteContent(),
                        note.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        note.isKindOfNote()))
                .toList();
    }

}
