package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AnimalDTO {
    String id;
    String name;
    String binomialName;
    String description;
}
