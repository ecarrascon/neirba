package com.neirba.neirba.neighborhood;

import com.neirba.neirba.exception.NeighborhoodNotFoundException;
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
                new NeighborhoodNotFoundException("Neighborhood with id " + id + " does not exist"));
    }

    public Neighborhood updateNeighborhood(Neighborhood neighborhood) {
        return neighborhoodRepo.save(neighborhood);
    }

    public void deleteNeighborhood(Long id) {
        neighborhoodRepo.deleteById(id);
    }

    public List<Neighborhood> findAllByCityName(String cityName) {
        return neighborhoodRepo.findAllByCityName(cityName);
    }

    public Neighborhood findNeighborhoodByNameAndCityName(String neighborhoodName, String cityName) {
        return neighborhoodRepo.findNeighborhoodByNameAndCityName(neighborhoodName, cityName)
                .orElseThrow(() -> new NeighborhoodNotFoundException("Neighborhood " + neighborhoodName + " not found"));
    }
}
