package dto;

import entity.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RealisateurResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissanceStr;
    private String nationalite;
    private List<Film> films;
}
