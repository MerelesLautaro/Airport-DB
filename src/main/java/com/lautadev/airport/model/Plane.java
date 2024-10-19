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
@Table(name = "planes")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tuition;
    private int capacity;
    private double autonomy;
    @ManyToOne
    private Manufacturer manufacturer;
    @ManyToOne
    private Model model;
    @OneToOne
    private Crew crew;

    // CREATE TABLE planes (
    //    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    //    tuition VARCHAR(255),
    //    capacity INT,
    //    autonomy DOUBLE,
    //    manufacturer_id BIGINT,
    //    model_id BIGINT,
    //    crew_id BIGINT,
    //    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id),
    //    FOREIGN KEY (model_id) REFERENCES models(id),
    //    FOREIGN KEY (crew_id) REFERENCES crews(id)
    //);

}
