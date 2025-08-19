package service;

import dto.FilmResponseDto;
import entity.Film;
import entity.Realisateur;
import exception.NotFoundException;
import org.springframework.stereotype.Service;
import repository.FilmRepository;
import repository.RealisateurRepository;

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
