package com.example.animalsexercise;

public class AnimalMissingException extends Exception{
    public AnimalMissingException(String id) {
        super("Animal with id " + id + " does not exist.");
    }
}
