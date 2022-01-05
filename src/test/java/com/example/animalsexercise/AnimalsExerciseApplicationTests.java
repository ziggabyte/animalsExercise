package com.example.animalsexercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimalsExerciseApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    AnimalsController animalsController;

    @Test
    void getAllTest() {
        List<Animal> animals = webTestClient.get()
                .uri("/api/animals")
                .exchange()
                .returnResult(Animal.class)
                .getResponseBody()
                .collectList()
                .block();

        assertEquals(2, animals.size());
    }

}
