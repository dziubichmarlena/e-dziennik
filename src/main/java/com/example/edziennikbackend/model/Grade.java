package com.example.edziennikbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gradeName;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "grade_id")
    List<Student> students;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "grades_teachers",
            joinColumns = @JoinColumn(name = "grade_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    List<Teacher> teachers;

}
