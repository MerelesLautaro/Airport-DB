package com.lautadev.airport.service;

import com.lautadev.airport.model.Employed;
import com.lautadev.airport.repository.IEmployedRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployedService implements IEmployedService{

    @Autowired
    private IEmployedRepository  employedRepository;

    @Override
    public Employed saveEmployed(Employed employed) {
        return employedRepository.save(employed);

        // INSERT INTO `employees` (`id`, `name`, `lastname`, `professionalCategory_id`, `crew_id`)
        // VALUES ('id', 'name', 'lastname', 'professionalCategory_id', 'crew_id');
    }

    @Override
    public List<Employed> getEmployees() {
        return employedRepository.findAll();

        // SELECT * FROM `employees`;
    }

    @Override
    public Optional<Employed> findEmployed(Long id) {
        return employedRepository.findById(id);

        // SELECT * FROM `employees` WHERE `id` = id;
    }

    @Override
    public void deleteEmployed(Long id) {
        employedRepository.deleteById(id);

        // DELETE FROM `employees` WHERE `id` = id;
    }

    @Override
    public Employed editEmployed(Long id, Employed employed) {
        Employed employedEdit = employedRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(employed,employedEdit);

        return this.saveEmployed(employedEdit);

        // UPDATE `employees` SET `name` = 'name', `lastname` = 'lastname',
        // `professionalCategory_id` = 'professionalCategory_id', `crew_id` = 'crew_id'
        // WHERE `id` = id;
    }
}
