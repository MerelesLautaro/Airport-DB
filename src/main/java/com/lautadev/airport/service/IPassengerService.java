package com.lautadev.airport.service;

import com.lautadev.airport.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface IPassengerService {
    public Passenger savePassenger(Passenger passenger);
    public List<Passenger> getPassengers();
    public Optional<Passenger> findPassenger(Long id);
    public void deletePassenger(Long id);
    public Passenger editPassenger(Long id, Passenger passenger);
}
