package com.lautadev.airport.repository;

import com.lautadev.airport.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelRepository extends JpaRepository<Model,Long> {
}
