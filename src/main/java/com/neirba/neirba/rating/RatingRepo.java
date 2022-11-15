package com.neirba.neirba.rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepo extends JpaRepository<Rating, Long> {
    Optional<Rating> findRatingsByNeighborhoodName(String neighborhoodName);
}

