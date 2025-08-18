package com.example.springapp.dto;

import com.example.springapp.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoResponseDto {

    private Long id;
    private String title;
    private String description;
    private String dateStr;
    private boolean done;


}
