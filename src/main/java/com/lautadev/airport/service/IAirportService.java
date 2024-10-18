package com.lautadev.airport.service;

import com.lautadev.airport.model.Airport;

import java.util.List;
import java.util.Optional;

public interface IAirportService {
    public Airport saveAirport(Airport airport);
    public List<Airport> getAirports();
    public Optional<Airport> findAirport(Long id);
    public void deleteAirport(Long id);
    public Airport editAirport(Long id, Airport airport);
}
