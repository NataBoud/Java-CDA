package org.example.exercice2.repository;

import org.example.exercice2.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur,Long> {
}
