package com.lautadev.airport.service;

import com.lautadev.airport.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IPlaneService {
    public Plane savePlane(Plane plane);
    public List<Plane> getPlanes();
    public Optional<Plane> findPlane(Long id);
    public void deletePlane(Long id);
    public Plane editPlane(Long id, Plane plane);
}
