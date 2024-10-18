package com.lautadev.airport.service;

import com.lautadev.airport.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface IManufacturerService {
    public Manufacturer saveManufacturer(Manufacturer manufacturer);
    public List<Manufacturer> getManufacturers();
    public Optional<Manufacturer> findManufacturer(Long id);
    public void deleteManufacturer(Long id);
    public Manufacturer editManufacturer(Long id, Manufacturer manufacturer);
}
