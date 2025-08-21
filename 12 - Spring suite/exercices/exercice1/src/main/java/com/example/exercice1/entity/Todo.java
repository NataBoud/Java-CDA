package com.example.exercice1.entity;


import com.example.exercice1.dto.TodoResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {


    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isValidate;
    private boolean toto;

// Receive => Entity => Response
    public TodoResponseDto entityToDto(){
        return TodoResponseDto.builder()
                .date(getDate())
                .title(getTitle())
                .description(getDescription())
                .id(getId())
                .isValidate(isValidate())
                .build();
    }

}
