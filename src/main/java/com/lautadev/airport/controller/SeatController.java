package com.lautadev.airport.controller;

import com.lautadev.airport.model.Seat;
import com.lautadev.airport.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private ISeatService seatService;

    @PostMapping("/save")
    public ResponseEntity<Seat> saveSeat(@RequestBody Seat seat){
        return ResponseEntity.ok(seatService.saveSeat(seat));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Seat>> getSeats(){
        return ResponseEntity.ok(seatService.getSeats());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Seat> findSeat(@PathVariable Long id){
        Optional<Seat> seat = seatService.findSeat(id);
        return seat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Long id){
        seatService.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Seat> editSeat(@PathVariable Long id, @RequestBody Seat seat){
        return ResponseEntity.ok(seatService.editSeat(id,seat));
    }
}
