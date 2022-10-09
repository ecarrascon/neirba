package com.neirba.neirba.city;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.findAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        return ResponseEntity.ok(city);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City newCity = cityService.addCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        City updateCity = cityService.updateCity(city);
        return ResponseEntity.ok(updateCity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok().build();
    }

}
