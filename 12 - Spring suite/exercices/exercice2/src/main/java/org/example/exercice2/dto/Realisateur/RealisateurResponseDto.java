package org.example.exercice2.dto.Realisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RealisateurResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;
}
