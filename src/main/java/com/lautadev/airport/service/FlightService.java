package com.lautadev.airport.service;

import com.lautadev.airport.model.Flight;
import com.lautadev.airport.repository.IFlightRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);

        // INSERT INTO `flights` (`id`, `date`, `origin_airport_id`, `destination_airport_id`, `plane_id`)
        // VALUES ('id', 'date', 'origin_airport_id', 'destination_airport_id', 'plane_id');
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();

        // SELECT * FROM `flights`;
    }

    @Override
    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);

        // SELECT * FROM `flights` WHERE `id` = id;
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);

        // DELETE FROM `flights` WHERE `id` = id;
    }

    @Override
    public Flight editFlight(Long id, Flight flight) {
        Flight flightEdit = flightRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(flight,flightEdit);

        return this.saveFlight(flightEdit);

        // UPDATE `flights` SET `date` = 'date',
        // `origin_airport_id` = 'origin_airport_id',
        // `destination_airport_id` = 'destination_airport_id',
        // `plane_id` = 'plane_id'
        // WHERE `id` = id;
    }
}
