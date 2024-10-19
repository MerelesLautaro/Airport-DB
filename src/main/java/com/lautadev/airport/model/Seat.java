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


    // ¿Que es un Trigger?

    /*
        Un trigger (o desencadenador) es un conjunto de instrucciones que se ejecutan automáticamente en respuesta a
        ciertos eventos en una base de datos. Estos eventos pueden incluir operaciones como inserciones, actualizaciones
        o eliminaciones en una tabla específica.

    */

    // Trigger que actualiza la disponibilidad del asiento, inicialmente se lo persiste en TRUE, cuando se le asigna el asiento
    // a un pasajero (passenger) el estado se cambia a FALSE indicando que ya no esta disponible para otro pasajaero.

    // CREATE TRIGGER after_insert_passenger AFTER INSERT ON passengers FOR EACH ROW BEGIN UPDATE
    // seats SET available = false WHERE id = NEW.seat_id; END;;

}
