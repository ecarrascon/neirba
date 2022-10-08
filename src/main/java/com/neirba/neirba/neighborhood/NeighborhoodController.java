package com.neirba.neirba.neighborhood;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neighborhood")
public class NeighborhoodController {
    private final NeighborhoodService neighborhoodService;

    public NeighborhoodController(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Neighborhood>> getAllNeighborhoods() {
        List<Neighborhood> neighborhoods = neighborhoodService.findAllNeighborhoods();
        return ResponseEntity.ok(neighborhoods);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Neighborhood> getNeighborhoodById(@PathVariable("id") Long id) {
        Neighborhood neighborhood = neighborhoodService.findNeighborhoodById(id);
        return ResponseEntity.ok(neighborhood);
    }

    @PostMapping("/add")
    public ResponseEntity<Neighborhood> addNeighborhood(@RequestBody Neighborhood neighborhood) {
        Neighborhood newNeighborhood = neighborhoodService.addNeighborhood(neighborhood);
        return new ResponseEntity<>(newNeighborhood, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Neighborhood> updateNeighborhood(@RequestBody Neighborhood neighborhood) {
        Neighborhood updateNeighborhood = neighborhoodService.updateNeighborhood(neighborhood);
        return ResponseEntity.ok(updateNeighborhood);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNeighborhood(@PathVariable("id") Long id) {
        neighborhoodService.deleteNeighborhood(id);
        return ResponseEntity.ok().build();
    }




}
