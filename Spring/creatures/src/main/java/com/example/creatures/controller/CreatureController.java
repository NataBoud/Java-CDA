package com.example.creatures.controller;

import com.example.creatures.dto.CreatureReceiveDto;
import com.example.creatures.dto.CreatureResponseDto;
import com.example.creatures.entity.Creature;
import com.example.creatures.service.CreatureService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creatures")
public class CreatureController {

    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    // POST /api/creatures → créer une créature
    @PostMapping
    public ResponseEntity<CreatureResponseDto> create(@Valid @RequestBody CreatureReceiveDto creatureReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creatureService.create(creatureReceiveDto));
    }

    // GET /api/creatures → récupérer toutes les créatures
    @GetMapping
    public ResponseEntity<List<CreatureResponseDto>> getAll() {
        return ResponseEntity.ok(creatureService.getAll());
    }

    // PUT /api/creatures/{id} → mettre à jour une créature
    @PutMapping("/{id}")
    public ResponseEntity<CreatureResponseDto> update(
        @PathVariable long id,
        @RequestBody CreatureReceiveDto creatureReceiveDto)
    {
        return ResponseEntity.ok(creatureService.update(id, creatureReceiveDto));
    }

    // DELETE /api/creatures/{id} → supprimer une créature
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        creatureService.delete(id);
        return ResponseEntity.ok(String.format("Deleted creature with id %d", id));
    }

    // GET /api/creatures/paged?page=0&size=5 → récupérer les créatures avec pagination
    @GetMapping("/paged")
    public Page<Creature> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String sort
    ) {
        String[] sortParams = sort.split(",");
        String sortField = sortParams[0];
        Sort.Direction direction = sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));

        return creatureService.getPage(pageable);
    }
    
}
