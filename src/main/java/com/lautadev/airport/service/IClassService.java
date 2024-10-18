package com.lautadev.airport.service;

import com.lautadev.airport.model.Class;

import java.util.List;
import java.util.Optional;

public interface IClassService {
    public Class saveClass(Class aClass);
    public List<Class> getClasses();
    public Optional<Class> findClass(Long id);
    public void deleteClass(Long id);
    public Class editClass(Long id,Class aClass);
}
