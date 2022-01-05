package com.example.animalsexercise;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "animal")
@Data
@NoArgsConstructor
public class AnimalEntity {
    @Id  String id;
    String name;
    String binomialName;

    public AnimalEntity(String name, String binomialName) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.binomialName = binomialName;
    }
}
