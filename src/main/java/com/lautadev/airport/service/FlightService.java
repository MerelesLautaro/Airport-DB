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
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight editFlight(Long id, Flight flight) {
        Flight flightEdit = flightRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(flight,flightEdit);

        return this.saveFlight(flightEdit);
    }
}
