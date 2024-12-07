package com.thinkitive.AirlineBooking.controller;

import com.thinkitive.AirlineBooking.dto.AirlineDto;
import com.thinkitive.AirlineBooking.service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping("/create")
    public ResponseEntity<AirlineDto> createAirline(@RequestBody @Valid AirlineDto airlineDto){
        return new ResponseEntity<>(airlineService.createAirlineDto(airlineDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDto> getAirlineById(@PathVariable int id){
        return new ResponseEntity<>(airlineService.getAirlineById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AirlineDto> updateAirline(@PathVariable int id,@RequestBody AirlineDto airlineDto){
        return new ResponseEntity<>(airlineService.updateAirline(id, airlineDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAirline(@PathVariable int id){
        return new ResponseEntity<>(airlineService.deleteAirline(id), HttpStatus.OK);
    }


}
