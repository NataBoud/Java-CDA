package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@Builder
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private String teacher;
    private String room;
    private LocalDateTime hours;

    @ManyToMany
    @JoinTable(name = "cours_student",
    joinColumns = @JoinColumn(name = "id_cours"),
    inverseJoinColumns = @JoinColumn(name = "id_student"))
    private List<Student> students;

    public Cours() {
        students = new ArrayList<>();
    }

    public void addStudent (Student student){students.add(student);}
}
