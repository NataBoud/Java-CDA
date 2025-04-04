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
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String libelle;

    @Column(unique = true, nullable = false)
    private String iban;

    @Column(nullable = false)
    private double balance;

    // Relation Many-to-Many avec Customer
    @ManyToMany
    @JoinTable(
            name = "customer_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;


    // Relation Many-to-One avec Agency
    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;


//    >- Un Account se compose des éléments suivants:
//            >>- id
//>>- libelle
//>>- IBAN
//>>- Balance
//>>- Agency
//>>- list Customer

//    >- Account :
//            >>- Relation many to many avec Customer (bidirectional)
//>>- Relation many to one avec Agency (1 Agency / many Account) (unidirectional)


}
