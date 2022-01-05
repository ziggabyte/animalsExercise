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
    public List<AnimalDTO> all() {
        return animalService.all()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AnimalDTO create(@RequestBody CreateAnimal createAnimal) {
        return toDTO(
                animalService.create(createAnimal.getName(), createAnimal.getBinomialName())
        );
    }

    @GetMapping("/{id}")
    public AnimalDTO get(@PathVariable("id") String id) throws Exception {
        return toDTO(animalService.get(id));
    }

    @PutMapping("/{id}")
    public AnimalDTO update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) throws Exception{
        return toDTO(
                animalService.update(id, updateAnimal.getName(), updateAnimal.getBinomialName())
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws Exception {
        animalService.delete(id);
    }

    private AnimalDTO toDTO(AnimalEntity animalEntity) {
        return new AnimalDTO(
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
