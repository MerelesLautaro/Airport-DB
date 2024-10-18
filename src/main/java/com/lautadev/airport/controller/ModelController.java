package com.lautadev.airport.controller;

import com.lautadev.airport.model.Model;
import com.lautadev.airport.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private IModelService modelService;

    @PostMapping("/save")
    public ResponseEntity<Model> saveModel(@RequestBody Model model){
        return ResponseEntity.ok(modelService.saveModel(model));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Model>> getModels(){
        return ResponseEntity.ok(modelService.getModels());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Model> findModel(@PathVariable Long id){
        Optional<Model> model = modelService.findModel(id);
        return model.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable Long id){
        modelService.deleteModel(id);
        return ResponseEntity.ok("Model deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Model> editModel(@PathVariable Long id, @RequestBody Model model){
        return ResponseEntity.ok(modelService.editModel(id,model));
    }


}
