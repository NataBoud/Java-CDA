package org.example.exercice2.dto.Film;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2.entity.Film;
import org.example.exercice2.exception.NotFoundException;
import org.example.exercice2.repository.RealisateurRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmReceiveDto {
    private String nom;
    private String dateSortieStr;
    private String description;
    private int duree;
    private String genre;
    private long realisateurId;

}
