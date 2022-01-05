package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class Animal {
    String id;
    String name;
    String binomialName;
}
