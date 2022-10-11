package com.neirba.neirba.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepo extends JpaRepository<Country, Long> {
    Optional<Country> findCountryById(Long id);
    Optional<Country> findCountryByName(String name);
}
