package com.example.library.web.rest;

import com.example.library.model.Author;
import com.example.library.model.Country;
import com.example.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    private List<Country> findAll(){
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Country> findById(@PathVariable Long id){
        return this.countryService.findById(id).map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
