package com.example.exercice4.controller;


import com.example.exercice4.model.Creature;
import com.example.exercice4.service.CreatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creature")
public class CreatureController {

    private CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @PostMapping
    public Creature create(@RequestBody Creature creature) {
        return creatureService.create(creature);
    }

    @GetMapping
    public List<Creature> findAll() {
        return creatureService.findAll();
    }

    @GetMapping("/{id}")
    public Creature findById(@PathVariable Long id) {
        Optional<Creature> creatureOptional = creatureService.findById(id);
//                if(creatureOptional.isPresent()){
//                    return creatureOptional.get();
//                }
//                return null;
        return creatureOptional.orElse(null);
    }

    @PutMapping("/{id}")
    public Creature update(@PathVariable Long id ,@RequestBody Creature creature) {
        return creatureService.update(id, creature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        creatureService.deleteById(id);
    }

    @GetMapping("/paged")
    public Page<Creature> findByPageable(
            @RequestParam(defaultValue = "0") int page, // numero de page
            @RequestParam(defaultValue = "5") int size, // taille de la page
            @RequestParam(defaultValue = "id,asc") String sort // champ + sens du tri
          //  @RequestParam(defaultValue = "id") String field // champ
          //  @RequestParam(defaultValue = "asc") String direction // sens du tri
    ) {
        String[] sortParams = sort.split(",");
        String sortField = sortParams[0];
        Sort.Direction direction = sortParams.length > 1 &&  sortParams[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size,Sort.by(direction, sortField));

        return creatureService.getAllCreaturesPaged(pageable);

    }




}
