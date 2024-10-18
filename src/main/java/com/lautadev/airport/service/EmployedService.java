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
    }

    @Override
    public List<Employed> getEmployees() {
        return employedRepository.findAll();
    }

    @Override
    public Optional<Employed> findEmployed(Long id) {
        return employedRepository.findById(id);
    }

    @Override
    public void deleteEmployed(Long id) {
        employedRepository.deleteById(id);
    }

    @Override
    public Employed editEmployed(Long id, Employed employed) {
        Employed employedEdit = employedRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(employed,employedEdit);

        return this.saveEmployed(employedEdit);
    }
}
