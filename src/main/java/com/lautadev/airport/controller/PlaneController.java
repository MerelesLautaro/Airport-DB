package com.lautadev.airport.controller;

import com.lautadev.airport.model.Plane;
import com.lautadev.airport.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @PostMapping("/save")
    public ResponseEntity<Plane> savePlane(@RequestBody Plane plane){
        return ResponseEntity.ok(planeService.savePlane(plane));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Plane>> getPlanes(){
        return ResponseEntity.ok(planeService.getPlanes());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Plane> findPlane(@PathVariable Long id){
        Optional<Plane> plane = planeService.findPlane(id);
        return plane.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlane(@PathVariable Long id){
        planeService.deletePlane(id);
        return ResponseEntity.ok("Plane deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Plane> editPlane(@PathVariable Long id, @RequestBody Plane plane){
        return ResponseEntity.ok(planeService.editPlane(id,plane));
    }

}
