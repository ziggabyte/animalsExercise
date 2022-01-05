package com.example.animalsexercise;

import lombok.Value;

import java.util.UUID;

@Value
public class Animal {
    String id;
    String name;
    String binomialName;

    public Animal(String name, String binomialName) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.binomialName = binomialName;
    }
}
