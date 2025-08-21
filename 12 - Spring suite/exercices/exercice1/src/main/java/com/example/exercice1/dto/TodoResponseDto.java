package com.example.exercice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TodoResponseDto {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isValidate;

}
