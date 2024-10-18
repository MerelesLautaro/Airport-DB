package com.lautadev.airport.repository;

import com.lautadev.airport.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaneRepository extends JpaRepository<Plane,Long> {
}
