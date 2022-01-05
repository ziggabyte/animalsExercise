package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
@AllArgsConstructor
public class AnimalsController {

    AnimalService animalService;

    @GetMapping
    public List<Animal> all() {
        return animalService.all()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Animal create(@RequestBody CreateAnimal createAnimal) {
        return toDTO(
                animalService.create(createAnimal.getName(), createAnimal.getBinomialName())
        );
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return toDTO(animalService.get(id));
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        return toDTO(
                animalService.update(id, updateAnimal.getName(), updateAnimal.getBinomialName())
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        animalService.delete(id);
    }

    private Animal toDTO(AnimalEntity animalEntity) {
        return new Animal(
                animalEntity.getId(),
                animalEntity.getName(),
                animalEntity.getBinomialName()
        );
    }

    @Value
    private static class CreateAnimal {
        String name;
        String binomialName;
    }

    @Value
    private static class UpdateAnimal {
        String name;
        String binomialName;
    }
}
