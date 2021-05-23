package com.robinstrom.animalinventory.api;

import com.robinstrom.animalinventory.infrastructure.Animal;
import com.robinstrom.animalinventory.infrastructure.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalApi {

    private final AnimalRepository repository;

    public AnimalApi(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return repository.findAll();
    }

    @GetMapping("/animal")
    public Animal getAnimal(Long id) {
        return repository.getById(id);
    }

    @PostMapping("/animal")
    public String addAnimal(Animal animal) {
        repository.save(animal);
        return "Animal was stored to DB: " + animal.toString();
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimal(@PathVariable Long id) {
        repository.deleteById(id);
    }
}