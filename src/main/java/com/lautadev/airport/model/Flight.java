package com.lautadev.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @ManyToOne
    private Airport origin_airport;
    @ManyToOne
    private Airport destination_airport;
    @ManyToOne
    private Plane plane;

    // CREATE TABLE flights (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    date DATETIME,
    //    origin_airport_id BIGINT,
    //    destination_airport_id BIGINT,
    //    plane_id BIGINT,
    //    FOREIGN KEY (origin_airport_id) REFERENCES Airports(id),
    //    FOREIGN KEY (destination_airport_id) REFERENCES Airports(id),
    //    FOREIGN KEY (plane_id) REFERENCES planes(id)
    //);

}
