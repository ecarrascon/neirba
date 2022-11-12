package com.neirba.neirba.dto.mapper;

import com.neirba.neirba.country.Country;
import com.neirba.neirba.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    CountryDTO countryToCountryDTO(Country country);
    Country countryDTOToCountry(CountryDTO countryDTO);

    default List<CountryDTO> countriesToCountriesDTO(List<Country> countries) {
        return countries.stream()
                .map(this::countryToCountryDTO)
                .collect(Collectors.toList());
    }

    default List<Country> countriesDTOToCountries(List<CountryDTO> countriesDTO) {
        return countriesDTO.stream()
                .map(this::countryDTOToCountry)
                .collect(Collectors.toList());
    }


}
