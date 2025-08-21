package org.example.exercice2.controller;

import org.example.exercice2.dto.Film.FilmReceiveDto;
import org.example.exercice2.dto.Film.FilmResponseDto;
import org.example.exercice2.entity.Film;
import org.example.exercice2.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue/film")
public class FilmController {

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<FilmResponseDto> create (@RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDto> update (@PathVariable long id, @RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.ok(service.update(id,filmReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        service.delete(id);
       return ResponseEntity.ok("Deleted") ;
    }

    @GetMapping("/realisateur/{id}")
    public ResponseEntity<List<FilmResponseDto>> getFilmByRealisateur (@PathVariable long id){
        return ResponseEntity.ok(service.getAllFilmByRealisateur(id));
    }

}
