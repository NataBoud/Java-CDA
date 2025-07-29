package com.example.exercice3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Cat {
    private String name;
    private String breed;
    private String favoriteMeal;
    private LocalDate birthDate;
}
