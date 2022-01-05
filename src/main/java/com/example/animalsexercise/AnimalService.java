package com.example.animalsexercise;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class AnimalService {

    Map<String, AnimalEntity> animals;

    public AnimalService () {
        this.animals = new HashMap<>();
        AnimalEntity lejon = new AnimalEntity("Lejon", "Storus hårus");
        AnimalEntity pingvin = new AnimalEntity("Pingvin", "Flappus armus");
        animals.put(lejon.getId(), lejon);
        animals.put(pingvin.getId(), pingvin);
    }

    public Stream<AnimalEntity> all() {
        return animals.values().stream();
    }

    public AnimalEntity create(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(name, binomialName);
        animals.put(animalEntity.getId(), animalEntity);
        return animalEntity;
    }

    public AnimalEntity get(String id) {
        return animals.get(id);
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        get(id).setName(name);
        get(id).setBinomialName(binomialName);
        return get(id);
    }

    public void delete(String id) {
        animals.remove(id);
    }
}
