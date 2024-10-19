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

        // INSERT INTO `seats` (`id`, `num_seat`, `available`, `plane_id`)
        // VALUES ('id', 'num_seat', 'available', 'plane_id');
    }

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();

        // SELECT * FROM `seats`;
    }

    @Override
    public Optional<Seat> findSeat(Long id) {
        return seatRepository.findById(id);

        // SELECT * FROM `seats` WHERE `id` = id;
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);

        // DELETE FROM `seats` WHERE `id` = id;
    }

    @Override
    public Seat editSeat(Long id, Seat seat) {
        Seat seatEdit = seatRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(seat,seatEdit);

        return this.saveSeat(seatEdit);

        // UPDATE `seats` SET `num_seat` = 'num_seat', `available` = 'available',
        // `plane_id` = 'plane_id' WHERE `id` = id;
    }
}
