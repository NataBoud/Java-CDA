package org.example;

import org.example.entity.Film;
import org.example.repository.FilmRepository;

public class Main {
    public static void main(String[] args) {
        FilmRepository filmRepository = new FilmRepository();

        Film film = Film.builder().title("Mon film").duration(125).categorie("animation").build();

        filmRepository.createOrUpdate(film);
    }
}