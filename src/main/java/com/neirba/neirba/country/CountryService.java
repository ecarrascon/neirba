package com.neirba.neirba.country;

import com.neirba.neirba.exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Country addCountry(Country country) {
        return countryRepo.save(country);
    }

    public List<Country> findAllCountries() {
        return countryRepo.findAll();
    }

    public Country findCountryById(Long id) {
        return countryRepo.findCountryById(id).orElseThrow(() ->
                new CountryNotFoundException("Country with id " + id + " does not exist"));
    }

    public Country updateCountry(Country country) {
        return countryRepo.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepo.deleteById(id);
    }

}
