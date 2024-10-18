package com.lautadev.airport.controller;

import com.lautadev.airport.model.Crew;
import com.lautadev.airport.service.ICrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private ICrewService crewService;

    @PostMapping("/save")
    public ResponseEntity<Crew> saveCrew(@RequestBody Crew crew){
        return ResponseEntity.ok(crewService.saveCrew(crew));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Crew>> getCrews(){
        return ResponseEntity.ok(crewService.getCrews());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Crew> findCrew(@PathVariable Long id){
        Optional<Crew> crew = crewService.findCrew(id);
        return crew.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCrew(@PathVariable Long id){
        crewService.deleteCrew(id);
        return ResponseEntity.ok("Crew deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Crew> editCrew(@PathVariable Long id, @RequestBody Crew crew){
        return ResponseEntity.ok(crewService.editCrew(id,crew));
    }


}

