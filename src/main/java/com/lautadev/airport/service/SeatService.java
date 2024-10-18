package com.lautadev.airport.service;

import com.lautadev.airport.model.Seat;
import com.lautadev.airport.repository.ISeatRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements ISeatService{

    @Autowired
    private ISeatRepository seatRepository;

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> findSeat(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Seat editSeat(Long id, Seat seat) {
        Seat seatEdit = seatRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(seat,seatEdit);

        return this.saveSeat(seatEdit);
    }
}
