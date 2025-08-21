package com.example.exercice_02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "La valeur ne doit pas être vide")
    private String firstname;
    @Size(min = 3, message = "Minimum de 3 lettres !")
    @NotBlank(message = "La valeur ne doit pas être vide")
    private String lastname;
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$", message = "Format de l'email invalide")
    private String email;
    @Min(value = 18)
    @Max(value = 60)
    private int age;
    private String photo;
}
