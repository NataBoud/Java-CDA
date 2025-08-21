package com.example.creatures.entity;
import com.example.creatures.dto.CreatureResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "creatures")
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private double weight;
    private boolean dangerous;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreatureType creatureType;

    public CreatureResponseDto entityToDto() {
        return CreatureResponseDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .creatureTypeStr(creatureType.name())
                .build();
    }

}
