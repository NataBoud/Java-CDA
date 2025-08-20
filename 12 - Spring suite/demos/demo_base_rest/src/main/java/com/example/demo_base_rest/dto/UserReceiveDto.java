package com.example.demo_base_rest.dto;

import com.example.demo_base_rest.entity.User;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserReceiveDto {

    @Size(min = 3, max = 25)
    private String name;
    @Pattern(regexp = "[0-9]{2}[-|\\\\/]{1}[0-9]{2}[-|\\\\/]{1}[0-9]{4}",message = "la date doit etre au format dd-MM-yyyy")
    private String birthDateStr;
    @Size(min = 4, message = "Le mot de passe doit faire au moins 4 characteres !!!!")
    private String password;


    public User dtoToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return User.builder()
                .name(name)
                .birthDate(LocalDate.parse(birthDateStr, formatter))
                .password(password)
                .build();
    }
}
