package com.lautadev.airport.service;

import com.lautadev.airport.model.Employed;

import java.util.List;
import java.util.Optional;

public interface IEmployedService {
    public Employed saveEmployed(Employed employed);
    public List<Employed> getEmployees();
    public Optional<Employed> findEmployed(Long id);
    public void deleteEmployed(Long id);
    public Employed editEmployed(Long id, Employed employed);
}
