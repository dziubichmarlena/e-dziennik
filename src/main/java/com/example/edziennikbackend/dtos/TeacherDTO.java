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

    private List<MarkDTO> marks;
}
