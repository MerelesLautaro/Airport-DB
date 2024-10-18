package com.lautadev.airport.controller;

import com.lautadev.airport.model.ProfessionalCategory;
import com.lautadev.airport.service.IProfessionalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professional-category")
public class ProfessionalCategoryController {

    @Autowired
    private IProfessionalCategoryService professionalCategoryService;

    @PostMapping("/save")
    public ResponseEntity<ProfessionalCategory> saveCategory(@RequestBody ProfessionalCategory  professionalCategory){
        return ResponseEntity.ok(professionalCategoryService.saveProfessionalCategory(professionalCategory));
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProfessionalCategory>> getCategories(){
        return ResponseEntity.ok(professionalCategoryService.getProfessionalsCategories());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfessionalCategory> findCategory(@PathVariable Long id){
        Optional<ProfessionalCategory> professionalCategory = professionalCategoryService.findProfessionalCategory(id);
        return professionalCategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        professionalCategoryService.deleteProfessionalCategory(id);
        return ResponseEntity.ok("Professional Category deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<ProfessionalCategory> editCategory(@PathVariable Long id, @RequestBody ProfessionalCategory professionalCategory){
        return ResponseEntity.ok(professionalCategoryService.editProfessionalCategory(id,professionalCategory));
    }

}
