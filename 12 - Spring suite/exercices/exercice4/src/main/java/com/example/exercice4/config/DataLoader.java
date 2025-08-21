package com.example.exercice4.config;


import com.example.exercice4.model.Creature;
import com.example.exercice4.model.CreatureType;
import com.example.exercice4.repository.CreatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {


    @Bean
    CommandLineRunner initDatabase(CreatureRepository creatureRepository) {
        return args -> {
            Random random = new Random();

            // Generer 50 créatures
            IntStream.range(1, 50).forEach(i -> {
                Creature creature = new Creature();
                creature.setName("Creature " + i);
                creature.setAge(random.nextInt(501));
                creature.setWeight(20+ random.nextDouble() *200);
                creature.setDangerous(random.nextBoolean());
                creature.setCreatureType(CreatureType.values()[random.nextInt(CreatureType.values().length)]);
                creatureRepository.save(creature);
            });
        };
    }
}
