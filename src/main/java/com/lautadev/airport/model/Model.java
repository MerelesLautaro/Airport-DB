package com.lautadev.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // CREATE TABLE models (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    name VARCHAR(255)
    //);
}
