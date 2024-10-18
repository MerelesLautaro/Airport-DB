package com.lautadev.airport.controller;

import com.lautadev.airport.model.Class;
import com.lautadev.airport.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private IClassService classService;

    @PostMapping("/save")
    public ResponseEntity<Class> saveClass(@RequestBody Class aClass){
        return ResponseEntity.ok(classService.saveClass(aClass));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Class>> getClasses(){
        return ResponseEntity.ok(classService.getClasses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Class> findClass(@PathVariable Long id){
        Optional<Class> aClass = classService.findClass(id);
        return aClass.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id){
        classService.deleteClass(id);
        return ResponseEntity.ok("Class deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Class> editClass(@PathVariable Long id, @RequestBody Class aClass){
        return ResponseEntity.ok(classService.editClass(id,aClass));
    }
}
