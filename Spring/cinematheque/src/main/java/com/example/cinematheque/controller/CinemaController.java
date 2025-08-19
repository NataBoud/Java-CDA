package com.example.cinematheque.controller;

import com.example.cinematheque.dto.FilmReceiveDto;
import com.example.cinematheque.dto.FilmResponseDto;
import com.example.cinematheque.dto.RealisateurReceiveDto;
import com.example.cinematheque.dto.RealisateurResponseDto;
import com.example.cinematheque.entity.Realisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cinematheque.service.CinemaService;

import java.util.List;

@RestController
@RequestMapping("api/catalogue")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    // ========================= FILMS =========================

    // create
    @PostMapping("/films/create")
    public ResponseEntity<FilmResponseDto> create(@RequestBody FilmReceiveDto filmReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.create(filmReceiveDto));
    }

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

    // create
    @PostMapping("/realisateur/create")
    public ResponseEntity<RealisateurResponseDto> create(@RequestBody RealisateurReceiveDto realisateurReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.create(realisateurReceiveDto));
    }

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
