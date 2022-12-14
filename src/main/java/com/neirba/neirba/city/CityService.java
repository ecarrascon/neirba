package com.neirba.neirba.city;

import com.neirba.neirba.exception.CityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City addCity(City city) {
        return cityRepo.save(city);
    }

    public List<City> findAllCities() {
        return cityRepo.findAll();
    }

    public List<City> findAllByCountryName(String countryName) {
        return cityRepo.findAllByCountryName(countryName);
    }

    public City findCityByNameAndCountryName(String cityName, String countryName) {
        return cityRepo.findCityByNameAndCountryName(cityName, countryName)
                .orElseThrow(() -> new CityNotFoundException("City " + cityName + " not found"));
    }

    public City findCityById(Long id) {
        return cityRepo.findCityById(id).orElseThrow(() ->
                new CityNotFoundException("City with id " + id + " does not exist"));
    }

    public City findCityByName(String name) {
        return cityRepo.findCityByName(name).orElseThrow(() ->
                new CityNotFoundException("City with name " + name + " does not exist"));
    }

    public City updateCity(City city) {
        return cityRepo.save(city);
    }

    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }


}
