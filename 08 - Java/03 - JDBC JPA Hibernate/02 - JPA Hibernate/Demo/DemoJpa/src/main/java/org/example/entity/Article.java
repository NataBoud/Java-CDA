//package org.example.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Article {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(unique = true, nullable = false)
//    private String name;
//    private float price;
//    private int quantity;
//    @Column(name = "restock_date")
//    private LocalDate restockDate;
//
//    @ManyToOne
//    @JoinColumn(name = "id_fabriquant")
//    private Fabriquant fabriquant;
//
//    @ManyToMany(mappedBy = "articles")
//    private List<Commande> commandes;
//
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", quantity=" + quantity +
//                ", restockDate=" + restockDate +
//                '}';
//    }
//}
