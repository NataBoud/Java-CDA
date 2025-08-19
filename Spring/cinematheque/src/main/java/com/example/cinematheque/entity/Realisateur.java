package com.example.cinematheque.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import com.example.cinematheque.dto.RealisateurResponseDto;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "realisateurs")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    private String nationalite;

    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL)
    private List<Film> films;

    public RealisateurResponseDto entityToDto() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return RealisateurResponseDto.builder()
                .id(getId())
                .nom(getNom())
                .dateNaissanceStr(dtf.format(getDateNaissance()))
                .nationalite(getNationalite())
                .build();
    }

}
