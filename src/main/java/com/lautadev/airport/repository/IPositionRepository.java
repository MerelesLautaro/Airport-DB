package com.lautadev.airport.repository;

import com.lautadev.airport.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Long> {
}
