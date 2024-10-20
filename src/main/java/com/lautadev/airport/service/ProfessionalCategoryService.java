package com.lautadev.airport.service;

import com.lautadev.airport.model.ProfessionalCategory;
import com.lautadev.airport.repository.IProfessionalCategoryRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalCategoryService implements IProfessionalCategoryService {

    @Autowired
    private IProfessionalCategoryRepository  professionalCategoryRepository;

    @Override
    public ProfessionalCategory saveProfessionalCategory(ProfessionalCategory professionalCategory) {
        return professionalCategoryRepository.save(professionalCategory);

        // INSERT INTO `professionals_categories` (`id`, `name`)
        // VALUES ('id', 'name');
    }

    @Override
    public List<ProfessionalCategory> getProfessionalsCategories() {
        return professionalCategoryRepository.findAll();

        // SELECT * FROM `professionals_categories`;
    }

    @Override
    public Optional<ProfessionalCategory> findProfessionalCategory(Long id) {
        return professionalCategoryRepository.findById(id);

        // SELECT * FROM `professionals_categories` WHERE `id` = id;
    }

    @Override
    public void deleteProfessionalCategory(Long id) {
        professionalCategoryRepository.deleteById(id);

        // DELETE FROM `professionals_categories` WHERE `id` = id;
    }

    @Override
    public ProfessionalCategory editProfessionalCategory(Long id, ProfessionalCategory professionalCategory) {
        ProfessionalCategory professionalCategoryEdit = professionalCategoryRepository.findById(id).orElseThrow(()
                                                        -> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(professionalCategory,professionalCategoryEdit);

        return this.saveProfessionalCategory(professionalCategoryEdit);

        // UPDATE `professionals_categories` SET `name` = 'name' WHERE `id` = id;
    }
}
