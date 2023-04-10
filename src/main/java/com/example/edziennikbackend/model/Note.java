package com.example.edziennikbackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noteContent;
    private LocalDate date = LocalDate.now();
    private boolean kindOfNote;

    @ManyToOne
    @JsonIgnore
    Student student;

    @ManyToOne
    @JsonIgnore
    Teacher teacher;

}
