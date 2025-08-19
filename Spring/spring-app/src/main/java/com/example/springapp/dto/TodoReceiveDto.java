package com.example.springapp.dto;


import com.example.springapp.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoReceiveDto {

    private String title;
    private String description;
    private String dateStr;

    public Todo dtoToEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Todo.builder()
                .title(title)
                .description(description)
                .date(LocalDate.parse(dateStr, dtf))
                .done(false)
                .build();
    }
}
