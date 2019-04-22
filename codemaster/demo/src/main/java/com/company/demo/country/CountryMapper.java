package com.company.demo.country;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toDto(Country country);

    Country toCountry(CountryDto countryDto);

    default CountryDto countryToDto(Country country) {
        CountryDto countryDto = this.toDto(country);
        return countryDto;
    }

    default List<CountryDto> listToRest(List<Country> countries) {
        return countries.stream().map(this::countryToDto).collect(Collectors.toList());
    }
}
