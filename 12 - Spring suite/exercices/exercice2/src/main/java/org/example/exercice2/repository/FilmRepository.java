package org.example.exercice2.repository;

import org.example.exercice2.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    @Query("select f from Film f where f.realisateur.id = ?1")
    List<Film> findAllByRealisateur (long idRealisateur);

 
}
