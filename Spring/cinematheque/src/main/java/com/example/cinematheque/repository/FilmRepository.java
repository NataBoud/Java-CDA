package com.example.cinematheque.repository;

import com.example.cinematheque.entity.Film;
import com.example.cinematheque.entity.Genre;
import com.example.cinematheque.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByRealisateur(Realisateur realisateur);

    List<Film> findByGenre(Genre genre);

}
