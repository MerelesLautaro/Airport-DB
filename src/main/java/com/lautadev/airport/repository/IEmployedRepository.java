package com.lautadev.airport.repository;

import com.lautadev.airport.model.Employed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployedRepository extends JpaRepository<Employed,Long> {
}
