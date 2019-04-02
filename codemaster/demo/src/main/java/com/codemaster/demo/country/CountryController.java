package com.codemaster.demo.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryMapper countryMapper;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/countries")
    public List<CountryDto> getCountries() {
        List<Country> countries = countryService.getAll();
        List<CountryDto> countryDtoList = countryMapper.listToRest(countries);
        return countryDtoList;
    }
}
