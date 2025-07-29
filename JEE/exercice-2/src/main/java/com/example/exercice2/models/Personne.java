package com.example.exercice2.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Personne {
    private String nom;
    private String prenom;
    private int age;
}
