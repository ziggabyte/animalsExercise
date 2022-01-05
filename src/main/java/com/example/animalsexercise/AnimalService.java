package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {
    AnimalRepository animalRepository;

    public Stream<AnimalEntity> all() {
        return animalRepository.findAll().stream();
    }

    public AnimalEntity create(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(name, binomialName);
        return animalRepository.save(animalEntity);
    }

    public AnimalEntity get(String id) throws Exception {
        Optional<AnimalEntity> optional = animalRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception(id);
        }
    }

    public AnimalEntity update(String id, String name, String binomialName) throws Exception {
        Optional<AnimalEntity> optionalAnimalEntity = animalRepository.findById(id);
        if (optionalAnimalEntity.isPresent()) {
            optionalAnimalEntity.get().setName(name);
            optionalAnimalEntity.get().setBinomialName(binomialName);
            return animalRepository.save(optionalAnimalEntity.get());
        } else {
            throw new Exception(id);
        }
    }

    public void delete(String id) throws Exception {
        Optional<AnimalEntity> optionalAnimalEntity = animalRepository.findById(id);
        if (optionalAnimalEntity.isPresent()) {
            animalRepository.delete(optionalAnimalEntity.get());
        } else {
            throw new Exception(id);
        }
    }
}
