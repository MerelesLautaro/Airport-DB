package com.lautadev.airport.controller;

import com.lautadev.airport.model.Passenger;
import com.lautadev.airport.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private IPassengerService passengerService;

    @PostMapping("/save")
    public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger){
        return ResponseEntity.ok(passengerService.savePassenger(passenger));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Passenger>> getPassengers(){
        return ResponseEntity.ok(passengerService.getPassengers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Passenger> findPassenger(@PathVariable Long id){
        Optional<Passenger> passenger = passengerService.findPassenger(id);
        return passenger.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Passenger> editPassenger(@PathVariable Long id, @RequestBody Passenger passenger){
        return ResponseEntity.ok(passengerService.editPassenger(id,passenger));
    }

}
