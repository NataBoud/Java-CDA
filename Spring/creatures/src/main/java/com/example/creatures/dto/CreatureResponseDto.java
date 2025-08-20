package com.example.creatures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatureResponseDto {
    private Long id;
    private String name;
    private int age;
    private double weight;
    private boolean dangerous;
    private String creatureTypeStr;
}
