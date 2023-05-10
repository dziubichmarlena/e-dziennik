package com.example.edziennikbackend.dtos;

import com.example.edziennikbackend.model.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GradeDTO {
    private Long id;

    public GradeDTO(Grade grade) {
        this.id = grade.getId();
    }
}
