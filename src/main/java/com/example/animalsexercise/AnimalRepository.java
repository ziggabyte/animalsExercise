package com.example.animalsexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, String> {
    Optional<AnimalEntity> findById(String id);
    List<AnimalEntity> findAll();
}
