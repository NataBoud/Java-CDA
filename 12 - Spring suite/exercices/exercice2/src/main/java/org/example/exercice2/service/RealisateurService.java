package org.example.exercice2.service;

import org.example.exercice2.dto.Realisateur.RealisateurReceiveDto;
import org.example.exercice2.dto.Realisateur.RealisateurResponseDto;
import org.example.exercice2.entity.Realisateur;
import org.example.exercice2.exception.NotFoundException;
import org.example.exercice2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    private RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public RealisateurResponseDto create (RealisateurReceiveDto realisateurReceiveDto){
        return realisateurRepository.save(realisateurReceiveDto.dtoToEntity()).entityToDto();
    }

    public RealisateurResponseDto get (long id){
        return realisateurRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<RealisateurResponseDto> get (){
        return realisateurRepository.findAll().stream().map(Realisateur::entityToDto).toList();
    }
}
