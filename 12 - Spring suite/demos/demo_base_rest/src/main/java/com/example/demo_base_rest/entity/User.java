package com.example.demo_base_rest.entity;

import com.example.demo_base_rest.dto.UserResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate birthDate;
    private String password;


    public UserResponseDto entityToDto() {
        return UserResponseDto.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .build();
    }


}
