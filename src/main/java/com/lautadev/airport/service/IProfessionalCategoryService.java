package com.lautadev.airport.service;

import com.lautadev.airport.model.ProfessionalCategory;

import java.util.List;
import java.util.Optional;

public interface IProfessionalCategoryService {
    public ProfessionalCategory saveProfessionalCategory(ProfessionalCategory professionalCategory);
    public List<ProfessionalCategory> getProfessionalsCategories();
    public Optional<ProfessionalCategory> findProfessionalCategory(Long id);
    public void deleteProfessionalCategory(Long id);
    public ProfessionalCategory editProfessionalCategory(Long id, ProfessionalCategory professionalCategory);
}
