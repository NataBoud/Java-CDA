package com.example.exercice4.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50, message = "Doit contenir 2 characteres minimum et 50 maximum")
    private String name;
    @Positive
    private int age;
    @Min(0)
    private double weight;
    @Column(name = "dangereux")
    private boolean dangerous;
    @NotNull
    private CreatureType creatureType;
}
