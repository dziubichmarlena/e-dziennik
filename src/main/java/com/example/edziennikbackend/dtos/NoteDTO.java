package com.example.edziennikbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NoteDTO {
    private Long id;
    private String teacher;
    private String student;
    private String content;
    private String date;
    private boolean type;

    public NoteDTO(String teacher, String content, String date, boolean type) {
        this.teacher = teacher;
        this.content = content;
        this.date = date;
        this.type = type;
    }

}
