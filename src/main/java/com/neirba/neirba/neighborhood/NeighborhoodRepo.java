package com.neirba.neirba.neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NeighborhoodRepo extends JpaRepository<Neighborhood, Long> {
    Optional<Neighborhood> findNeighborhoodById(Long id);

    List<Neighborhood> findAllByCityName(String cityName);

    Optional<Neighborhood> findNeighborhoodByNameAndCityName(String neighborhoodName, String cityName);
}

