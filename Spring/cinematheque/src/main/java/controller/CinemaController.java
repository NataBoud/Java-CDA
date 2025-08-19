package controller;

import dto.FilmResponseDto;
import entity.Realisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CinemaService;

import java.util.List;

@RestController
@RequestMapping("api/catalogue")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    // ========================= FILMS =========================

    // Liste des films
    @GetMapping("/films")
    public ResponseEntity<List<FilmResponseDto>> getAllFilms() {
        System.out.println("Test");
        return ResponseEntity.ok(cinemaService.getAllFilms());
    }

    // Un film par ID
    @GetMapping("/film/{id}")
    public ResponseEntity<FilmResponseDto> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.getFilmById(id));
    }

    // ========================= REALISATEURS =========================

    // Liste des réalisateurs
    @GetMapping("/realisateurs")
    public ResponseEntity<List<Realisateur>> getAllRealisateurs() {
        System.out.println("Testb passage");
        return ResponseEntity.ok(cinemaService.getAllRealisateurs());
    }

    // Fiche d'un réalisateur par ID
    @GetMapping("/realisateur/{id}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.getRealisateurById(id));
    }

    // Liste des films par réalisateur
    @GetMapping("/realisateur/{id}/films")
    public ResponseEntity<List<FilmResponseDto>> getFilmsByRealisateur(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.getFilmsByRealisateur(id));
    }
}
