package com.lautadev.airport.service;

import com.lautadev.airport.model.Class;
import com.lautadev.airport.repository.IClassRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService{

    @Autowired
    private IClassRepository classRepository;

    @Override
    public Class saveClass(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> findClass(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    @Override
    public Class editClass(Long id, Class aClass) {
        Class aClassEdit = classRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(aClass,aClassEdit);

        return this.saveClass(aClassEdit);
    }
}
