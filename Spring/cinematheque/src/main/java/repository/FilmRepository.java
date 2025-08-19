package repository;

import entity.Film;
import entity.Genre;
import entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByRealisateur(Realisateur realisateur);

    List<Film> findByGenre(Genre genre);

}
