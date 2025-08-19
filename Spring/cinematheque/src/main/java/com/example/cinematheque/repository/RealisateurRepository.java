package com.example.cinematheque.repository;

import com.example.cinematheque.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

    Realisateur findByNom(String nom);

}
