package com.example.exercice4.service;


import com.example.exercice4.model.Creature;
import com.example.exercice4.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatureService {

    @Autowired
    private CreatureRepository creatureRepository;

    public Creature create(Creature creature) {
        return creatureRepository.save(creature);
    }

    public List<Creature> findAll() {
        return creatureRepository.findAll();
    }

    public Optional<Creature> findById(Long id) {
        return creatureRepository.findById(id);
    }

    public Page<Creature> getAllCreaturesPaged(Pageable pageable) {
        return creatureRepository.findAll(pageable);
    }

    public Creature update(Long id,Creature updatedCreature) {
        return creatureRepository.findById(id).map(c -> {
            c.setName(updatedCreature.getName());
            c.setAge(updatedCreature.getAge());
            c.setWeight(updatedCreature.getWeight());
            c.setDangerous(updatedCreature.isDangerous());
            c.setCreatureType(updatedCreature.getCreatureType());
            return creatureRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Creature not found"));
    }

    public void deleteById(Long id) {
        creatureRepository.deleteById(id);
    }

}
