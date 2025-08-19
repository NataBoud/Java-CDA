package com.example.cinematheque.service;

import com.example.cinematheque.dto.FilmReceiveDto;
import com.example.cinematheque.dto.FilmResponseDto;
import com.example.cinematheque.dto.RealisateurReceiveDto;
import com.example.cinematheque.dto.RealisateurResponseDto;
import com.example.cinematheque.entity.Film;
import com.example.cinematheque.entity.Realisateur;
import com.example.cinematheque.exception.NotFoundException;
import org.springframework.stereotype.Service;
import com.example.cinematheque.repository.FilmRepository;
import com.example.cinematheque.repository.RealisateurRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private final FilmRepository filmRepository;
    private final RealisateurRepository realisateurRepository;

    public CinemaService(FilmRepository filmRepository, RealisateurRepository realisateurRepository) {
        this.filmRepository = filmRepository;
        this.realisateurRepository = realisateurRepository;
    }

    // ========================= FILMS =========================

    // CREATE
    public FilmResponseDto create(FilmReceiveDto filmReceiveDto) {
        return filmRepository.save(filmReceiveDto.dtoToFilm()).entityToDto();
    }

    // Récupérer tous les films
    public List<FilmResponseDto> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(Film::entityToDto)
                .toList();
    }

    // Récupérer un film par son ID
    public FilmResponseDto getFilmById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(NotFoundException::new)
                .entityToDto();
    }

    // Récupérer les films par réalisateur
    public List<FilmResponseDto> getFilmsByRealisateur(Long realisateurId) {
        Realisateur realisateur = realisateurRepository.findById(realisateurId)
                .orElseThrow(NotFoundException::new);
        return realisateur.getFilms()
                .stream()
                .map(Film::entityToDto)
                .collect(Collectors.toList());
    }

    // ========================= REALISATEURS =========================

    // CREATE
    public RealisateurResponseDto create(RealisateurReceiveDto realisateurReceiveDto) {
        return realisateurRepository.save(realisateurReceiveDto.dtoToRealisateur()).entityToDto();
    }

    // Récupérer tous les réalisateurs
    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    // Récupérer un réalisateur par son ID
    public Realisateur getRealisateurById(Long id) {
        return realisateurRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
