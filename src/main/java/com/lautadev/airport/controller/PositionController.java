package com.lautadev.airport.controller;

import com.lautadev.airport.model.Position;
import com.lautadev.airport.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @PostMapping("/save")
    public ResponseEntity<Position> savePosition(@RequestBody Position position){
        return ResponseEntity.ok(positionService.savePosition(position));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Position>> getPositions(){
        return ResponseEntity.ok(positionService.getPositions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Position> findPosition(@PathVariable Long id){
        Optional<Position> position  = positionService.findPosition(id);
        return position.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable Long id){
        positionService.deletePosition(id);
        return ResponseEntity.ok("Position deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Position> editPosition(@PathVariable Long id, @RequestBody Position position){
        return ResponseEntity.ok(positionService.editPosition(id,position));
    }



}
