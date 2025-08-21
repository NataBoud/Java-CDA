package org.example.exercice2.dto.Film;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2.dto.Realisateur.RealisateurResponseDto;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FilmResponseDto {
    private Long id;
    private String nom;
    private LocalDate dateSortie;
    private String description;
    private int duree;
    private String genre;
    private RealisateurResponseDto realisateur;
}
