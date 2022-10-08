package com.neirba.neirba.neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NeighborhoodRepo extends JpaRepository<Neighborhood, Long> {
    Optional<Neighborhood> findNeighborhoodById(Long id);
}

