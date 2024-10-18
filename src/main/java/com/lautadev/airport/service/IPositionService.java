package com.lautadev.airport.service;

import com.lautadev.airport.model.Position;

import java.util.List;
import java.util.Optional;

public interface IPositionService {
    public Position savePosition(Position position);
    public List<Position> getPositions();
    public Optional<Position> findPosition(Long id);
    public void deletePosition(Long id);
    public Position editPosition(Long id, Position position);
}
