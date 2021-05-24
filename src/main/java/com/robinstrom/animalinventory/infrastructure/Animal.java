package com.robinstrom.animalinventory.infrastructure;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;

    Animal() {}

    public Animal(String name, String species) {

        this.name = name;
        this.species = species;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Animal))
            return false;
        Animal animal = (Animal) o;
        return Objects.equals(this.id, animal.id) && Objects.equals(this.name, animal.name)
                && Objects.equals(this.species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.species);
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + this.id + ", name='" + this.name + '\'' + ", species='" + this.species + '\'' + '}';
    }
}
