package dto;

import entity.Film;
import entity.Genre;
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

    public Film dtoToFilm() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Film.builder()
                .nom(nom)
                .dateSortie(LocalDate.parse(dateSortieStr, dtf))
                .description(description)
                .duree(duree)
                .genre(Genre.valueOf(genre.toUpperCase()))
                .build();
    }
}
