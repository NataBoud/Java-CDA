package org.example.ExoHiberante2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // Relation Many-to-Many avec Account
    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts;

//    >- Un Customer se compose des éléments suivants:
//            >>- id
//>>- lastName
//>>- firstName
//>>- birthDate
//>>- List Account

//    >- Customer :
//            >>- Relation Many to many avec Account (bidirectional)


}
