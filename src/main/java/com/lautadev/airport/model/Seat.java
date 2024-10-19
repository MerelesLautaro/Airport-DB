package com.lautadev.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num_seat;
    private boolean available;
    @ManyToOne
    private Plane plane;

    // CREATE TABLE seats (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    num_seat INT,
    //    available BOOLEAN,
    //    plane_id BIGINT,
    //    FOREIGN KEY (plane_id) REFERENCES planes(id)
    //);
}
