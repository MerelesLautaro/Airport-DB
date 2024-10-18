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
    @OneToOne(cascade = CascadeType.ALL)
    private Crew crew;
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    private Flight flight;
}
