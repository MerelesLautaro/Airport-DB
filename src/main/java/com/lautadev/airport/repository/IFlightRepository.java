package com.lautadev.airport.repository;

import com.lautadev.airport.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Long> {
}
