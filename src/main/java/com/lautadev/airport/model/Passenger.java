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
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    @OneToOne
    private Seat seat;
    @ManyToOne
    private Class aClass;

    // CREATE TABLE passengers (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    name VARCHAR(255),
    //    lastname VARCHAR(255),
    //    dni VARCHAR(255),
    //    seat_id BIGINT,
    //    class_id BIGINT,
    //    FOREIGN KEY (seat_id) REFERENCES seats(id),
    //    FOREIGN KEY (class_id) REFERENCES classes(id)
    //);
}
