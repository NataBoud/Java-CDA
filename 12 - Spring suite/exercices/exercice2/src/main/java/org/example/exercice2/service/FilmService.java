package org.example.exercice2.service;

import org.example.exercice2.dto.Film.FilmReceiveDto;
import org.example.exercice2.dto.Film.FilmResponseDto;
import org.example.exercice2.entity.Film;
import org.example.exercice2.exception.NotFoundException;
import org.example.exercice2.repository.FilmRepository;
import org.example.exercice2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final RealisateurRepository realisateurRepository;

    public FilmService(FilmRepository filmRepository,  RealisateurRepository realisateurRepository) {
        this.filmRepository = filmRepository;
        this.realisateurRepository = realisateurRepository;
    }

    public FilmResponseDto create (FilmReceiveDto filmReceiveDto){
        return filmRepository.save(dtoToEntity(filmReceiveDto)).entityToDto();
    }

    public FilmResponseDto get (long id){
        return filmRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<FilmResponseDto> get (){
        return filmRepository.findAll().stream().map(Film::entityToDto).toList();
    }

    public void delete (long id){
        filmRepository.deleteById(id);
    }

    public FilmResponseDto update (long id, FilmReceiveDto filmReceiveDto){
        Film filmFound = filmRepository.findById(id).orElseThrow(NotFoundException::new);
        Film filmReceive = dtoToEntity(filmReceiveDto);
        filmFound.setNom(filmReceive.getNom());
        filmFound.setDateSortie(filmReceive.getDateSortie());
        filmFound.setDescription(filmReceive.getDescription());
        filmFound.setDuree(filmReceive.getDuree());
        filmFound.setGenre(filmReceive.getGenre());
        filmFound.setRealisateur(filmReceive.getRealisateur());

        return filmRepository.save(filmFound).entityToDto();
    }

    public List<FilmResponseDto> getAllFilmByRealisateur (long idRealisateur){
        return filmRepository.findAllByRealisateur(idRealisateur).stream().map(Film::entityToDto).toList();
    }


    private Film dtoToEntity (FilmReceiveDto receiveDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Film.builder()
                .nom(receiveDto.getNom())
                .dateSortie(LocalDate.parse(receiveDto.getDateSortieStr(),formatter))
                .description(receiveDto.getDescription())
                .duree(receiveDto.getDuree())
                .genre(receiveDto.getGenre())
                .realisateur(realisateurRepository
                        .findById(receiveDto.getRealisateurId())
                        .orElseThrow(NotFoundException::new))
                .build();
    }
}
