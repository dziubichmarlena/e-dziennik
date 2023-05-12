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
    private String gradeName;
    public GradeDTO(Grade grade) {
        this.id = grade.getId();
    }

    public GradeDTO(Long id, String gradeName) {
        this.id = id;
        this.gradeName = gradeName;
    }
}
