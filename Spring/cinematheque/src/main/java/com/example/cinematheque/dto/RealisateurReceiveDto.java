package com.example.cinematheque.dto;

import com.example.cinematheque.entity.Realisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealisateurReceiveDto {
    private String nom;
    private String dateNaissanceStr;
    private String nationalite;

    public Realisateur dtoToRealisateur() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Realisateur.builder()
                .nom(nom)
                .dateNaissance(LocalDate.parse(dateNaissanceStr, dtf))
                .nationalite(nationalite)
                .build();
    }

}
