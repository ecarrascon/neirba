package com.neirba.neirba.dto.mapper;

import com.neirba.neirba.city.City;
import com.neirba.neirba.dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO cityToCityDTO(City city);
    City cityDTOToCity(CityDTO cityDTO);

    default List<CityDTO> citiesToCitiesDTO(List<City> cities) {
        return cities.stream()
                .map(this::cityToCityDTO)
                .collect(Collectors.toList());
    }

    default List<City> citiesDTOToCities(List<CityDTO> citiesDTO) {
        return citiesDTO.stream()
                .map(this::cityDTOToCity)
                .collect(Collectors.toList());
    }



}
