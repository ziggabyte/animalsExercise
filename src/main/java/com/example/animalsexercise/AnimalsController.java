package com.example.animalsexercise;

import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalsController {

    private List<Animal> animals;

    public AnimalsController() {
        this.animals = new ArrayList<>();
        animals.add(new Animal("Lejon", "Storus hårus"));
        animals.add(new Animal("Kråka", "Corvus corvus"));
    }

    @GetMapping
    public List<Animal> all() {
        return animals;
    }

    @PostMapping
    public Animal create(@RequestBody CreateAnimal createAnimal) {
        return new Animal(createAnimal.getName(), createAnimal.getBinomialName());
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return new Animal("Råtta", "Litus mumsis");
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id) {
        return new Animal("Pingvin", "Snyggus frackus");
    }

    @Value
    public static class CreateAnimal {
        String name;
        String binomialName;
    }
}
