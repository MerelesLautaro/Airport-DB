package com.lautadev.airport.controller;

import com.lautadev.airport.model.Airport;
import com.lautadev.airport.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @PostMapping("/save")
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
        return ResponseEntity.ok(airportService.saveAirport(airport));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Airport>> getAirports(){
        return ResponseEntity.ok(airportService.getAirports());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Airport> findAirport(@PathVariable Long id){
        Optional<Airport> airport = airportService.findAirport(id);
        return airport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id){
        airportService.deleteAirport(id);
        return ResponseEntity.ok("Airport deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Airport> editAirport(@PathVariable Long id, @RequestBody Airport airport){
        return ResponseEntity.ok(airportService.editAirport(id,airport));
    }
}
