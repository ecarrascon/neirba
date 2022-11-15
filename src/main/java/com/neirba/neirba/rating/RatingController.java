package com.neirba.neirba.rating;

import com.neirba.neirba.neighborhood.Neighborhood;
import com.neirba.neirba.neighborhood.NeighborhoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    private final NeighborhoodService neighborhoohService;

    public RatingController(RatingService ratingService, NeighborhoodService neighborhoohService) {
        this.ratingService = ratingService;
        this.neighborhoohService = neighborhoohService;
    }

    //Find all ratings by neighborhood name
    @GetMapping("/find/neighborhood/{neighborhoodName}")
    public ResponseEntity<Rating> findRatingsByNeighborhoodName(@PathVariable("neighborhoodName") String neighborhoodName) {
        Rating rating = ratingService.findRatingsByNeighborhoodName(neighborhoodName);
        return ResponseEntity.ok(rating);
    }

    @PostMapping("/add/neighborhood/{neighborhoodName}/{cityName}")
    public ResponseEntity<Rating> addRating(@PathVariable(value = "neighborhoodName") String neighborhoodName, @PathVariable(value = "cityName") String cityName, @RequestBody Rating rating) {
       Neighborhood neighborhoodSetter = neighborhoohService.findNeighborhoodByNameAndCityName(neighborhoodName,cityName);
        if (neighborhoodSetter.getName().equals(neighborhoodName)) {
            rating.setNeighborhood(neighborhoodSetter);
            return ResponseEntity.ok(ratingService.addRating(rating));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }


}
