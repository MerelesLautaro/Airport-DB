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
@Table(name = "employees")
public class Employed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @ManyToOne
    private Position position;

    // CREATE TABLE employees (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    name VARCHAR(255),
    //    lastname VARCHAR(255),
    //    position_id BIGINT,
    //    FOREIGN KEY (position_id) REFERENCES positions(id)
    //);
}
