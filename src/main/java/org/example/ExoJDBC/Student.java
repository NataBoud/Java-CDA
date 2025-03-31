package org.example.ExoJDBC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    private int id;
    private String nom;
    private String prenom;
    private String numero_classe;
    private LocalDate date_diplome;

}
