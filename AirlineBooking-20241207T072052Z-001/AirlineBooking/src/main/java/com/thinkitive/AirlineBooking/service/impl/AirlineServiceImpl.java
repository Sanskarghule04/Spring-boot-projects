package com.thinkitive.AirlineBooking.service.impl;

import com.thinkitive.AirlineBooking.dto.AirlineDto;
import com.thinkitive.AirlineBooking.dto.FlightDto;
import com.thinkitive.AirlineBooking.entity.Airline;
import com.thinkitive.AirlineBooking.entity.Flights;
import com.thinkitive.AirlineBooking.repository.AirlineRepository;
import com.thinkitive.AirlineBooking.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public AirlineDto createAirlineDto(AirlineDto airlineDto) {
        //List<Flights> list = airlineDto.getFlights().stream().map(Flights::toEntity).toList();

        List<Flights> flights=new ArrayList<>();

        for(FlightDto flightDto: airlineDto.getFlights()){
            flights.add(Flights.toEntity(flightDto));
        }

        Airline airline = Airline.mapToAirline(airlineDto, flights);
        Airline airline2 =  airlineRepository.save(airline);

        return Airline.mapToAirlineDto(airline2);
    }

    @Override
    public AirlineDto getAirlineById(int id) {
        Airline airline = airlineRepository.findById(id).get();
        return Airline.mapToAirlineDto(airline);
    }

    @Override
    public AirlineDto updateAirline(int id, AirlineDto airlineDto) {
        Airline airline = airlineRepository.findById(id).get();

        List<FlightDto> list = airlineDto.getFlights();

        return Airline.toUpdate(airline, airlineDto, list);
    }

    @Override
    public String deleteAirline(int id) {
        if(airlineRepository.findById(id).get() != null){
            airlineRepository.deleteById(id);
            return "Airline Deleted Sucessfully!...";
        }
        return "please enter valid id";
    }

}
