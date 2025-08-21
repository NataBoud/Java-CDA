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
//@Table(name = "fabriquants")
//public class Fabriquant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  int id;
//    private String name;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "id_adresse")
//    @Embedded
//    private Adresse adresse;
//
//    @OneToMany(mappedBy = "fabriquant")
//    List<Article> articles ;
//
//}
