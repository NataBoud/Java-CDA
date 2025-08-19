package com.example.cinematheque.dto;

import com.example.cinematheque.entity.Film;
import com.example.cinematheque.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmReceiveDto {

    private String nom;
    private String dateSortieStr;
    private String description;
    private int duree;
    private String genre;
    private Long realisateurId;

}
