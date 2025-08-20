package com.example.demo_base_rest.config;


import com.example.demo_base_rest.entity.User;
import com.example.demo_base_rest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            //Generer 50 USER
            IntStream.rangeClosed(1,50).forEach(i -> {
                User user = new User();
                user.setName("User -"+i);
                user.setPassword("password-"+i);
                user.setBirthDate(LocalDate.now().minusDays(i));
                userRepository.save(user);
            });
        };
    }
}
