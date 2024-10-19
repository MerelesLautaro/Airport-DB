package com.lautadev.airport.service;

import com.lautadev.airport.model.Airport;
import com.lautadev.airport.repository.IAirportRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService implements IAirportService{

    @Autowired
    private IAirportRepository airportRepository;

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);

        // INSERT INTO `Airports` (`id`, `name`) VALUES ('id', 'name');
    }

    @Override
    public List<Airport> getAirports() {
        return airportRepository.findAll();

        // SELECT * FROM `Airports`;
    }

    @Override
    public Optional<Airport> findAirport(Long id) {
        return airportRepository.findById(id);

        // SELECT * FROM `Airports` WHERE `id` = id;
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);

        // DELETE FROM `Airports` WHERE `id` = id;
    }

    @Override
    public Airport editAirport(Long id, Airport airport) {
        Airport airportEdit = airportRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(airport,airportEdit);

        return this.saveAirport(airportEdit);

        // UPDATE `Airports` SET `name` = 'name' WHERE `id` = id;
    }
}
