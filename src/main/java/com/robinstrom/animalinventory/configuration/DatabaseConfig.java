package com.robinstrom.animalinventory.configuration;

import com.robinstrom.animalinventory.infrastructure.Animal;
import com.robinstrom.animalinventory.infrastructure.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Animal("Fido", "Dog")));
            log.info("Preloading " + repository.save(new Animal("Wesley", "Cat")));
        };
    }
}
