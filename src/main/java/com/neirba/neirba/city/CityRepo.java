package com.neirba.neirba.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepo extends JpaRepository<City, Long> {
    Optional<City> findCityById(Long id);
    Optional<City> findCityByName(String name);

    Optional<City> findCityByNameAndCountryName(String cityName, String countryName);

    List<City> findAllByCountryName(String countryName);
}
