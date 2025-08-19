package com.example.cinematheque.entity;

import com.example.cinematheque.dto.FilmResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    @Column(name = "date_sortie")
    private LocalDate dateSortie;

    @Column(length = 2000)
    private String description;

    private int duree;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realisateur_id", nullable = false)
    private Realisateur realisateur;

    public FilmResponseDto entityToDto() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return FilmResponseDto.builder()
                .id(getId())
                .nom(getNom())
                .dateSortieStr(dtf.format(dateSortie))
                .description(getDescription())
                .duree(getDuree())
                .genre(String.valueOf(getGenre()))
                .realisateur(getRealisateur().entityToDto())
                .build();
    }

}
