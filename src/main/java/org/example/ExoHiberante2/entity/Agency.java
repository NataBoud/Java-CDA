package org.example.ExoHiberante2.entity;

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
@Table(name = "agencies")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "agency")
    private List<Account> accounts;

//    >- Une Agency se compose des éléments suivant:
//            >>- id
//>>- adresse

//    >- Agency:
//            >>-Relation one to many avec Account (many Account / 1 Agency ) (unidirectional)

}
