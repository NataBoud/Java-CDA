//package org.example.entity;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Commande {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "numeros_commande")
//    private String numerosCommande;
//
//    @ManyToMany
//    @JoinTable(name = "commande_article",
//    joinColumns = @JoinColumn(name = "id_commande"),
//    inverseJoinColumns = @JoinColumn(name = "id_article"))
//    private List<Article> articles;
//}
