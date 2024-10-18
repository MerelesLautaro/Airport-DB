package com.lautadev.airport.service;

import com.lautadev.airport.model.Passenger;
import com.lautadev.airport.repository.IPassengerRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService implements IPassengerService{

    @Autowired
    public IPassengerRepository passengerRepository;

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> findPassenger(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    @Override
    public Passenger editPassenger(Long id, Passenger passenger) {
        Passenger passengerEdit = passengerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(passenger,passengerEdit);

        return this.savePassenger(passengerEdit);
    }
}
