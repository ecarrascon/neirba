package com.neirba.neirba.neighborhood;

import com.neirba.neirba.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeighborhoodService {
    private final NeighborhoodRepo neighborhoodRepo;

    public NeighborhoodService(NeighborhoodRepo neighborhoodRepo) {
        this.neighborhoodRepo = neighborhoodRepo;
    }

    public Neighborhood addNeighborhood(Neighborhood neighborhood) {
        return neighborhoodRepo.save(neighborhood);
    }

    public List<Neighborhood> findAllNeighborhoods() {
        return neighborhoodRepo.findAll();
    }

    public Neighborhood findNeighborhoodById(Long id) {
        return neighborhoodRepo.findNeighborhoodById(id).orElseThrow(() ->
                new UserNotFoundException("Neighborhood with id " + id + " does not exist"));
    }

    public Neighborhood updateNeighborhood(Neighborhood neighborhood) {
        return neighborhoodRepo.save(neighborhood);
    }

    public void deleteNeighborhood(Long id) {
        neighborhoodRepo.deleteById(id);
    }
}
