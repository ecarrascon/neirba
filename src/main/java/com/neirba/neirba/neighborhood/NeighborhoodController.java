package com.neirba.neirba.neighborhood;


import com.neirba.neirba.city.City;
import com.neirba.neirba.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neighborhood")
public class NeighborhoodController {
    @Autowired
    private NeighborhoodService neighborhoodService;
    @Autowired
    private CityService cityService;

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

    @GetMapping("/find/all/city/{cityName}")
    public ResponseEntity<List<Neighborhood>> getNeighborhoodsByCityName(@PathVariable("cityName") String cityName) {
        List<Neighborhood> neighborhoods = neighborhoodService.findAllByCityName(cityName);
        return ResponseEntity.ok(neighborhoods);
    }

    @GetMapping("/find/neighborhood/{neighborhoodName}/city/{cityName}")
    public ResponseEntity<Neighborhood> getNeighborhoodByCityNameAndNeighborhoodName
            (@PathVariable("cityName") String cityName, @PathVariable("neighborhoodName") String neighborhoodName) {
        Neighborhood neighborhood = neighborhoodService.findNeighborhoodByNameAndCityName(neighborhoodName, cityName);
        return ResponseEntity.ok(neighborhood);
    }

    @PostMapping("/add/{countryName}/{cityName}")
    public ResponseEntity<Neighborhood> addNeighborhood
            (@PathVariable(value = "countryName")
             String countryName, @PathVariable(value = "cityName") String cityName, @RequestBody Neighborhood neighborhood) {
        City city;
        try {
            city = cityService.findCityByName(cityName);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (city.getCountry().getName().equals(countryName)) {
            neighborhood.setCity(city);
            Neighborhood newNeighborhood = neighborhoodService.addNeighborhood(neighborhood);
            return ResponseEntity.ok(newNeighborhood);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
