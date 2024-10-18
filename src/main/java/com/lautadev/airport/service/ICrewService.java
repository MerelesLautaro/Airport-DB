package com.lautadev.airport.service;

import com.lautadev.airport.model.Crew;

import java.util.List;
import java.util.Optional;

public interface ICrewService {
    public Crew saveCrew(Crew crew);
    public List<Crew> getCrews();
    public Optional<Crew> findCrew(Long id);
    public void deleteCrew(Long id);
    public Crew editCrew(Long id, Crew crew);
}
