package com.lautadev.airport.controller;

import com.lautadev.airport.model.Manufacturer;
import com.lautadev.airport.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private IManufacturerService manufacturerService;

    @PostMapping("/save")
    public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer){
        return ResponseEntity.ok(manufacturerService.saveManufacturer(manufacturer));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Manufacturer>> getManufacturers(){
        return ResponseEntity.ok(manufacturerService.getManufacturers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Manufacturer> findManufacturer(@PathVariable Long id){
        Optional<Manufacturer> manufacturer = manufacturerService.findManufacturer(id);
        return manufacturer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable Long id){
        manufacturerService.deleteManufacturer(id);
        return ResponseEntity.ok("Manufacturer deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Manufacturer> editManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer){
        return ResponseEntity.ok(manufacturerService.editManufacturer(id,manufacturer));
    }

}
