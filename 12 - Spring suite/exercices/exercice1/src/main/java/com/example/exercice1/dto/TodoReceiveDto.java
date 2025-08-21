package com.example.exercice1.dto;

import com.example.exercice1.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoReceiveDto {

    private String title;
    private String description;
    private String date;

    public Todo dtoToEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Todo.builder()
                .title(title)
                .description(description)
                .date(LocalDate.parse(date, dtf))
                .isValidate(false)
                .build();
    }
}
