package org.example.exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2.dto.Film.FilmResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Film {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private LocalDate dateSortie;
    private String description;
    private int duree;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    public FilmResponseDto entityToDto (){
        return FilmResponseDto.builder()
                .id(getId())
                .nom(getNom())
                .dateSortie(getDateSortie())
                .description(getDescription())
                .duree(getDuree())
                .genre(getGenre())
                .realisateur(getRealisateur().entityToDto())
                .build();
    }
}
