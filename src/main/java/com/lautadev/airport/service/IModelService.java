package com.lautadev.airport.service;

import com.lautadev.airport.model.Model;

import java.util.List;
import java.util.Optional;

public interface IModelService {
    public Model saveModel(Model model);
    public List<Model> getModels();
    public Optional<Model> findModel(Long id);
    public void deleteModel(Long id);
    public Model editModel(Long id,Model model);
}
