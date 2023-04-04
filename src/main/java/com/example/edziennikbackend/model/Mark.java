package com.example.edziennikbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String markNote;
    private double markValue;

    @ManyToOne
    @JsonIgnore
    Student student;

    @ManyToOne
    @JsonIgnore
    Teacher teacher;

}
