package com.lautadev.airport.repository;

import com.lautadev.airport.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<Class,Long> {
}
