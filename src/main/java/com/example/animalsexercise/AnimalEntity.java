package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AnimalEntity {
    String id;
    String name;
    String binomialName;

    public AnimalEntity(String name, String binomialName) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.binomialName = binomialName;
    }
}
