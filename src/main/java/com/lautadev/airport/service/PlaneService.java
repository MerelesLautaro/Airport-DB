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

        // INSERT INTO `planes` (`id`, `tuition`, `capacity`, `autonomy`,
        // `manufacturer_id`, `model_id`, `crew_id`)
        // VALUES ('id', 'tuition', 'capacity', 'autonomy',
        // 'manufacturer_id', 'model_id', 'crew_id');
    }

    @Override
    public List<Plane> getPlanes() {
        return planeRepository.findAll();

        // SELECT * FROM `planes`;
    }

    @Override
    public Optional<Plane> findPlane(Long id) {
        return planeRepository.findById(id);

        // SELECT * FROM `planes` WHERE `id` = id;
    }

    @Override
    public void deletePlane(Long id) {
        planeRepository.deleteById(id);

        // DELETE FROM `planes` WHERE `id` = id;
    }

    @Override
    public Plane editPlane(Long id, Plane plane) {
        Plane planeEdit = planeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(plane,planeEdit);

        return this.savePlane(planeEdit);

        // UPDATE `planes` SET `tuition` = 'tuition', `capacity` = 'capacity',
        // `autonomy` = 'autonomy', `manufacturer_id` = 'manufacturer_id',
        // `model_id` = 'model_id', `crew_id` = 'crew_id'
        // WHERE `id` = id;
    }
}
