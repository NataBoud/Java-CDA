package org.example.ExoHibernate.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "numero_class")
    private String numeroClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @OneToMany(mappedBy = "student")
    List<Exam> exams;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

}
