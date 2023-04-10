package com.example.edziennikbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private String studentSurname;

    @OneToOne
    User user;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    Grade grade;


}
