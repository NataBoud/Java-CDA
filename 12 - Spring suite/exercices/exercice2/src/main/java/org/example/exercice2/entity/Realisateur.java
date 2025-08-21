package org.example.exercice2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2.dto.Realisateur.RealisateurResponseDto;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Realisateur {

    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;

    @OneToMany(mappedBy = "realisateur")
    private List<Film> films;

    public RealisateurResponseDto entityToDto (){
        return RealisateurResponseDto.builder()
                .id(getId())
                .nom(getNom())
                .prenom(getPrenom())
                .dateNaissance(getDateNaissance())
                .nationalite(getNationalite())
                .build();
    }
}
