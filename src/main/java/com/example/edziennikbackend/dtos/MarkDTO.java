package com.example.edziennikbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class MarkDTO {

    private String markNote;
    private double markValue;

    private Long id;
    private String student;
    private String teacher;

    public MarkDTO(String markNote, double markValue) {
        this.markNote = markNote;
        this.markValue = markValue;
    }
}
