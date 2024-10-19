package com.lautadev.airport.service;

import com.lautadev.airport.model.Position;
import com.lautadev.airport.repository.IPositionRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService{

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);

        // INSERT INTO `positions` (`id`, `name`, `professionalCategory_id`)
        // VALUES ('id', 'name', 'professionalCategory_id');
    }

    @Override
    public List<Position> getPositions() {
        return positionRepository.findAll();

        // SELECT * FROM `positions`;

    }

    @Override
    public Optional<Position> findPosition(Long id) {
        return positionRepository.findById(id);

        // SELECT * FROM `positions` WHERE `id` = id;
    }

    @Override
    public void deletePosition(Long id) {
        positionRepository.deleteById(id);

        // DELETE FROM `positions` WHERE `id` = id;
    }

    @Override
    public Position editPosition(Long id, Position position) {
        Position positionEdit = positionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("Entity Not Found")));

        NullAwareBeanUtils.copyNonNullProperties(position,positionEdit);

        return this.savePosition(positionEdit);

        // UPDATE `positions` SET `name` = 'name', `professionalCategory_id` = 'professionalCategory_id'
        // WHERE `id` = id;

    }
}
