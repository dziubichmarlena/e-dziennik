package com.example.edziennikbackend.dtos;

import com.example.edziennikbackend.model.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String studentName;
    private String studentSurname;
    private GradeDTO grade;

    private UserDTO user;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentSurname = student.getStudentSurname();
        this.grade = new GradeDTO(student.getGrade());
        this.user = new UserDTO(student.getUser());
    }
}
