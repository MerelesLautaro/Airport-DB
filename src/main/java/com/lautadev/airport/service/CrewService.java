package com.lautadev.airport.service;

import com.lautadev.airport.model.Crew;
import com.lautadev.airport.repository.ICrewRepository;
import com.lautadev.airport.throwable.EntityNotFoundException;
import com.lautadev.airport.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewService implements ICrewService{

    @Autowired
    private ICrewRepository crewRepository;

    @Override
    public Crew saveCrew(Crew crew) {
        return crewRepository.save(crew);

        // INSERT INTO `crews` (`id`) VALUES ('id');
    }

    @Override
    public List<Crew> getCrews() {
        return crewRepository.findAll();

        // SELECT * FROM `crews`;
    }

    @Override
    public Optional<Crew> findCrew(Long id) {
        return crewRepository.findById(id);

        // SELECT * FROM `crews` WHERE `id` = id;
    }

    @Override
    public void deleteCrew(Long id) {
        crewRepository.deleteById(id);

        // DELETE FROM `crews` WHERE `id` = id;
    }

    @Override
    public Crew editCrew(Long id, Crew crew) {
        Crew crewEdit = crewRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(crew,crewEdit);

        return this.saveCrew(crewEdit);

        // UPDATE `crews` SET ... WHERE `id` = id;
    }
}
