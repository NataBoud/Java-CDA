package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private String iban;
    private float balance;

    @ManyToMany
    @JoinTable(name = "account_customer",
    joinColumns = @JoinColumn(name = "id_account"),
    inverseJoinColumns = @JoinColumn(name = "id_customer"))
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "id_agency")
    private Agency agency;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                ", agency=" + agency +
                '}';
    }
}
