package org.example.exercice2.dto.Realisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2.entity.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RealisateurReceiveDto {
    private String nom;
    private String prenom;
    private String dateNaissanceStr;
    private String nationalite;

    public Realisateur dtoToEntity (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Realisateur.builder()
                .nom(getNom())
                .prenom(getPrenom())
                .dateNaissance(LocalDate.parse(getDateNaissanceStr(),formatter))
                .nationalite(getNationalite())
                .build();
    }
}
