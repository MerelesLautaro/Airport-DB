package com.lautadev.airport.controller;

import com.lautadev.airport.model.Employed;
import com.lautadev.airport.service.IEmployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employed")
public class EmployedController {

    @Autowired
    private IEmployedService employedService;

    @PostMapping("/save")
    public ResponseEntity<Employed> saveEmployed(@RequestBody Employed employed){
        return ResponseEntity.ok(employedService.saveEmployed(employed));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employed>> getEmployees(){
        return ResponseEntity.ok(employedService.getEmployees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employed> findEmployed(@PathVariable Long id){
        Optional<Employed> employed =  employedService.findEmployed(id);
        return employed.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployed(@PathVariable Long id){
        employedService.deleteEmployed(id);
        return ResponseEntity.ok("Employed deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Employed> editEmployed(@PathVariable Long id, @RequestBody Employed employed){
        return ResponseEntity.ok(employedService.editEmployed(id,employed));
    }


}
