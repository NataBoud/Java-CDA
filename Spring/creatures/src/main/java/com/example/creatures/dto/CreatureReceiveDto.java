package com.example.creatures.dto;

import com.example.creatures.entity.Creature;
import com.example.creatures.entity.CreatureType;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatureReceiveDto {

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 3, max = 25, message = "Le nom doit contenir entre 3 et 25 caractères")
    private String name;

    @Min(value = 0, message = "L'âge ne peut pas être négatif")
    private int age;

    @Positive(message = "Le poids doit être positif")
    private double weight;

    private boolean dangerous;

    @NotNull(message = "Le type de créature est obligatoire")
    private String creatureTypeStr;

    public Creature dtoToEntity() {
        return Creature.builder()
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .creatureType(CreatureType.valueOf(creatureTypeStr.toUpperCase()))
                .build();
    }
}
