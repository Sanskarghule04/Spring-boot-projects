package com.thinkitive.AirlineBooking.service;

import com.thinkitive.AirlineBooking.dto.AirlineDto;
import org.springframework.http.HttpStatusCode;

public interface AirlineService {
    AirlineDto createAirlineDto(AirlineDto airlineDto);

    AirlineDto getAirlineById(int id);

    AirlineDto updateAirline(int id, AirlineDto airlineDto);

    String deleteAirline(int id);
}
