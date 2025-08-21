package org.example.exercice2.controller;

import org.example.exercice2.dto.Realisateur.RealisateurReceiveDto;
import org.example.exercice2.dto.Realisateur.RealisateurResponseDto;
import org.example.exercice2.service.RealisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue/realisateur")
public class RealisateurController {

    private RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RealisateurResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealisateurResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }
    @PostMapping
    public ResponseEntity<RealisateurResponseDto> get (@RequestBody RealisateurReceiveDto realisateurReceiveDto){
        return ResponseEntity.ok(service.create(realisateurReceiveDto));
    }
}
