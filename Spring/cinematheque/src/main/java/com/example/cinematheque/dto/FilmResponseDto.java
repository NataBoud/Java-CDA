package com.example.cinematheque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResponseDto {
    private Long id;
    private String nom;
    private String dateSortieStr;
    private String description;
    private int duree;
    private String genre;
    private RealisateurResponseDto realisateur;
}
