package org.example.ExoHibernate.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "adresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    @Column(name = "code_postal")
    private String codePostal;

    @OneToOne(mappedBy = "adresse")
    private Student student;


}
