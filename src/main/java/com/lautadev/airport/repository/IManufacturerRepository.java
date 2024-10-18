package com.lautadev.airport.repository;

import com.lautadev.airport.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
