package com.lautadev.airport.service;

import com.lautadev.airport.model.Model;
import com.lautadev.airport.repository.IModelRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService implements IModelService{

    @Autowired
    private IModelRepository modelRepository;

    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findModel(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Model editModel(Long id, Model model) {
        Model modelEdit = modelRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(model,modelEdit);

        return this.saveModel(modelEdit);
    }
}
