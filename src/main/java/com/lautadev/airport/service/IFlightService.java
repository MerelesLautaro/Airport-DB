package com.lautadev.airport.service;

import com.lautadev.airport.model.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlightService {
    public Flight saveFlight(Flight flight);
    public List<Flight> getFlights();
    public Optional<Flight> findFlight(Long id);
    public void deleteFlight(Long id);
    public Flight editFlight(Long id, Flight flight);
}
