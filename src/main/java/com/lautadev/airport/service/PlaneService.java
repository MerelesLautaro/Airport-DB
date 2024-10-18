package com.lautadev.airport.service;

import com.lautadev.airport.model.Plane;
import com.lautadev.airport.repository.IPlaneRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService implements IPlaneService{

    @Autowired
    private IPlaneRepository planeRepository;

    @Override
    public Plane savePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public List<Plane> getPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Optional<Plane> findPlane(Long id) {
        return planeRepository.findById(id);
    }

    @Override
    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

    @Override
    public Plane editPlane(Long id, Plane plane) {
        Plane planeEdit = planeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(plane,planeEdit);

        return this.savePlane(planeEdit);
    }
}
