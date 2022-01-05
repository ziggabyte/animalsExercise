package com.example.animalsexercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalsController {

    @GetMapping
    public List<Animal> all() {
        return List.of(
                new Animal("Lejon", "Storus hårus"),
                new Animal("Kråka", "Corvus corvus")
        );
    }
}
