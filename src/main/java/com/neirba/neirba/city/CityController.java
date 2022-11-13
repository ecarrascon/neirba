package com.neirba.neirba.city;

import com.neirba.neirba.country.CountryService;
import com.neirba.neirba.dto.CityDTO;
import com.neirba.neirba.dto.mapper.CityMapper;
import com.neirba.neirba.exception.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;
    private final CountryService countryService;
    private final CityMapper cityMapper = CityMapper.INSTANCE;

    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> citiesDTO = cityMapper.citiesToCitiesDTO(cityService.findAllCities());
        return ResponseEntity.ok(citiesDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long id) {
        CityDTO cityDTO = cityMapper.cityToCityDTO(cityService.findCityById(id));
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping("/find/all/country/{countryName}")
    public ResponseEntity<List<CityDTO>> getCitiesByCountryName(@PathVariable("countryName") String countryName) {
        List<CityDTO> citiesDTO = cityMapper.citiesToCitiesDTO(cityService.findAllByCountryName(countryName));
        return ResponseEntity.ok(citiesDTO);
    }

    @GetMapping("/find/city/{cityName}/country/{countryName}")
    public ResponseEntity<CityDTO> getCityByCountryNameAndCityName(@PathVariable("countryName") String countryName, @PathVariable("cityName") String cityName) {
        CityDTO cityDTO = cityMapper.cityToCityDTO(cityService.findCityByNameAndCountryName(cityName, countryName));
        return ResponseEntity.ok(cityDTO);
    }



    @PostMapping("/add/{countryName}")
    public ResponseEntity<City> addCity(@PathVariable(value = "countryName") String countryName, @RequestBody City city) {
        try {
            city.setCountry(countryService.findCountryByName(countryName));
        } catch (CountryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
