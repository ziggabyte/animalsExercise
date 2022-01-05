package com.example.animalsexercise;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {
    AnimalRepository animalRepository;
    JsonPlaceholderRemote jsonPlaceholderRemote;

    public Stream<AnimalEntity> all() {
        return animalRepository.findAll().stream();
    }

    public AnimalEntity create(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(name, binomialName);
        return animalRepository.save(animalEntity);
    }

    public AnimalEntity get(String id) throws AnimalMissingException {
        return animalRepository
                .findById(id)
                .orElseThrow(() -> new AnimalMissingException(id));
    }

    public AnimalEntity update(String id, String name, String binomialName)
            throws AnimalMissingException {
        AnimalEntity animalEntity = animalRepository
                .findById(id)
                .orElseThrow(() -> new AnimalMissingException(id));
        animalEntity.setName(name);
        animalEntity.setBinomialName(binomialName);
        return animalRepository.save(animalEntity);
    }

    public void delete(String id) throws AnimalMissingException {
        AnimalEntity animalEntity = animalRepository
                .findById(id)
                .orElseThrow(() -> new AnimalMissingException(id));
        animalRepository.delete(animalEntity);
    }

    public AnimalEntity link(String id, String remoteId) throws AnimalMissingException {
        JsonPlaceholderPost post = jsonPlaceholderRemote.apiCall(remoteId);
        AnimalEntity animal = get(id);
        animal.setDescription(post.getBody());
        return animal;
    }
}
