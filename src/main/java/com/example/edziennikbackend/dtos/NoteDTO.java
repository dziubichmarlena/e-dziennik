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
    private String teacher;
    private String content;
    private String date;
}
