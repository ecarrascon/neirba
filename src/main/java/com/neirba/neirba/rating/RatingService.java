package com.neirba.neirba.rating;

import com.neirba.neirba.exception.RatingNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepo ratingRepo;

    public RatingService(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    public Rating findRatingsByNeighborhoodName(String neighborhoodName) {
        return ratingRepo.findRatingsByNeighborhoodName(neighborhoodName).orElseThrow(() ->
                new RatingNotFoundException("Rating with neighborhood name " + neighborhoodName + " does not exist"));
    }

    public Rating addRating(Rating rating) {
        return ratingRepo.save(rating);
    }


}
