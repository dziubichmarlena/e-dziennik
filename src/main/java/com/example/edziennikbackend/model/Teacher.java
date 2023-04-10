package com.example.edziennikbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teacherName;
    private String teacherSurname;
    private String subject;

    @OneToOne
    User user;

    @ManyToMany
    @JoinTable(
            name = "grades_teachers",
            joinColumns = @JoinColumn(name = "grade_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    List<Grade> grades;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    List<Mark> marks;

}
