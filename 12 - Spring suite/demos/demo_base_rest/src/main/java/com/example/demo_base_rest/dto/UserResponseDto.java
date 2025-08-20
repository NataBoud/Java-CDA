package com.example.demo_base_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponseDto {

    private long id;
    private String name;
    private LocalDate birthDate;
}
