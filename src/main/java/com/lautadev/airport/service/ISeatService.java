package com.lautadev.airport.service;

import com.lautadev.airport.model.Seat;

import java.util.List;
import java.util.Optional;

public interface ISeatService {
    public Seat saveSeat(Seat seat);
    public List<Seat> getSeats();
    public Optional<Seat> findSeat(Long id);
    public void deleteSeat(Long id);
    public Seat editSeat(Long id, Seat seat);
}
