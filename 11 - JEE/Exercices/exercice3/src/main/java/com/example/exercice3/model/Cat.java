package com.example.exercice3.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String breed;
    private String favMeal;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    public Cat() {
    }

    public Cat(String name, String breed, String favMeal, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.favMeal = favMeal;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFavMeal() {
        return favMeal;
    }

    public void setFavMeal(String favMeal) {
        this.favMeal = favMeal;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
