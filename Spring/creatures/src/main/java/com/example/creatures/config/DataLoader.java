package com.example.creatures.config;


import com.example.creatures.entity.Creature;
import com.example.creatures.entity.CreatureType;
import com.example.creatures.repository.CreatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    private final Random random = new Random();

    @Bean
    CommandLineRunner initDatabase(CreatureRepository creatureRepository) {
        return args -> {

//            IntStream.rangeClosed(1,100).forEach(i -> {
//                Creature creature = Creature.builder()
//                        .name("Creature-" + i)
//                        .age(random.nextInt(100))
//                        .weight(5 + random.nextDouble() * 95)
//                        .dangerous(random.nextBoolean())
//                        .creatureType(CreatureType.values()[random.nextInt(CreatureType.values().length)])
//                        .build();
//
//                creatureRepository.save(creature);
//            });
        };

    }
}
