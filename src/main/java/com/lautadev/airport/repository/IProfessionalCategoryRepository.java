package com.lautadev.airport.repository;

import com.lautadev.airport.model.ProfessionalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionalCategoryRepository extends JpaRepository<ProfessionalCategory,Long> {
}
