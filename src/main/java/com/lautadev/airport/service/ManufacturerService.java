package com.lautadev.airport.service;

import com.lautadev.airport.model.Manufacturer;
import com.lautadev.airport.repository.IManufacturerRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService implements IManufacturerService{

    @Autowired
    private IManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);

        // INSERT INTO `manufacturers` (`id`, `name`) VALUES ('id', 'name');
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();

        // SELECT * FROM `manufacturers`;
    }

    @Override
    public Optional<Manufacturer> findManufacturer(Long id) {
        return manufacturerRepository.findById(id);

        // SELECT * FROM `manufacturers` WHERE `id` = id;
    }

    @Override
    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);

        // DELETE FROM `manufacturers` WHERE `id` = id;
    }

    @Override
    public Manufacturer editManufacturer(Long id, Manufacturer manufacturer) {
        Manufacturer manufacturerEdit = manufacturerRepository.findById(id).orElseThrow(
                                        ()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(manufacturer,manufacturerEdit);

        return this.saveManufacturer(manufacturerEdit);

        // UPDATE `manufacturers` SET `name` = 'name' WHERE `id` = id;
    }
}
