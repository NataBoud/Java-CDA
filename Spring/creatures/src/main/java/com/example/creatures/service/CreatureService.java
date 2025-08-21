package com.example.creatures.service;

import com.example.creatures.dto.CreatureReceiveDto;
import com.example.creatures.dto.CreatureResponseDto;
import com.example.creatures.entity.Creature;
import com.example.creatures.exception.NotFoundException;
import com.example.creatures.repository.CreatureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {
    private final CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    // CREATE
    public CreatureResponseDto create(CreatureReceiveDto creatureReceiveDto) {
        return creatureRepository.save(creatureReceiveDto.dtoToEntity()).entityToDto();
    }

    // GET by id
    public CreatureResponseDto get(long id) {
        return creatureRepository.findById(id)
                .orElseThrow(NotFoundException::new)
                .entityToDto();
    }

    // GET all
    public List<CreatureResponseDto> getAll() {
        return creatureRepository.findAll()
                .stream()
                .map(Creature::entityToDto)
                .toList();
    }

    // UPDATE
    public CreatureResponseDto update(long id, CreatureReceiveDto creatureReceiveDto) {
        Creature creatureFound = creatureRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        Creature creatureGet = creatureReceiveDto.dtoToEntity();

        creatureFound.setName(creatureGet.getName());
        creatureFound.setAge(creatureGet.getAge());
        creatureFound.setWeight(creatureGet.getWeight());
        creatureFound.setDangerous(creatureGet.isDangerous());
        creatureFound.setCreatureType(creatureGet.getCreatureType());

        return creatureRepository.save(creatureFound).entityToDto();
    }

    // DELETE
    public void delete(long id) {
        creatureRepository.deleteById(id);
    }

    // PAGINATION
    public Page<Creature> getPage(Pageable pageable) {
        return creatureRepository.findAll(pageable);
    }

}
