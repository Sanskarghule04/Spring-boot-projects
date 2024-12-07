package com.thinkitive.AirlineBooking.entity;

import com.thinkitive.AirlineBooking.dto.AirlineDto;
import com.thinkitive.AirlineBooking.dto.FlightDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "airline")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String country;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private List<Flights> flights;

    public static Airline mapToAirline(AirlineDto airlineDto, List<Flights> flights){
        return Airline.builder()
                .name(airlineDto.getName())
                .country(airlineDto.getCountry())
                .flights(flights)
                .build();
    }

    public static AirlineDto mapToAirlineDto(Airline airline){
        return AirlineDto.builder()
                .id(airline.getId())
                .name(airline.getName())
                .country(airline.getCountry())
                .flights(!ObjectUtils.isEmpty(airline.getFlights())? airline.getFlights().stream().map(Flights::toDto).toList():null).build();
    }

    public static AirlineDto toUpdate(Airline airline, AirlineDto airlineDto, List<FlightDto> list){
        airlineDto.setId(airline.getId());
        airlineDto.setName(airline.getName());
        airlineDto.setCountry(airline.getCountry());
        airlineDto.setFlights(list);
        return airlineDto;
    }

}
