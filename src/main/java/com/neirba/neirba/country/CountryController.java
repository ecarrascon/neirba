package com.neirba.neirba.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.findAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable("name") String name) {
        Country country = countryService.findCountryByName(name);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id) {
        Country country = countryService.findCountryById(id);
        return ResponseEntity.ok(country);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
        Country updateCountry = countryService.updateCountry(country);
        return ResponseEntity.ok(updateCountry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok().build();
    }

}
