package com.lautadev.airport.controller;

import com.lautadev.airport.model.Flight;
import com.lautadev.airport.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private IFlightService flightService;

    @PostMapping("/save")
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
        return ResponseEntity.ok(flightService.saveFlight(flight));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Flight> findFlight(@PathVariable Long id){
        Optional<Flight> flight = flightService.findFlight(id);
        return flight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Flight> editFlight(@PathVariable Long id, @RequestBody Flight flight){
        return ResponseEntity.ok(flightService.editFlight(id,flight));
    }


}
