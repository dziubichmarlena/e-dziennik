package com.example.edziennikbackend.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TeacherDTO {

    private String teacherName;
    private String teacherSurname;
    private String subject;
    private String telephone;
    private String classroom;
    private String teacherInfo;
    private List<MarkDTO> marks;
    private List<GradeDTO> grade;

    public TeacherDTO(String subject, List<MarkDTO> marks) {
        this.subject = subject;
        this.marks = marks;
    }

    public TeacherDTO(String teacherName, String teacherSurname, String telephone, String classroom, String teacherInfo) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.telephone = telephone;
        this.classroom = classroom;
        this.teacherInfo = teacherInfo;
    }

    public TeacherDTO(List<GradeDTO> grade) {
        this.grade = grade;
    }
}
