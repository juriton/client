package com.codemaster.demo.country;

import com.codemaster.demo.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
