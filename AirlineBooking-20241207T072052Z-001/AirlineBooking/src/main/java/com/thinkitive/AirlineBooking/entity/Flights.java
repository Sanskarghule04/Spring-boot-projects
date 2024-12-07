package com.thinkitive.AirlineBooking.entity;

import com.thinkitive.AirlineBooking.dto.FlightDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flights")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;

    public static Flights toEntity(FlightDto flightDto) {
        return Flights.builder()
                .flightNumber(flightDto.getFlightNumber())
                .destination(flightDto.getDestination())
                .origin(flightDto.getOrigin())
                .departureTime(flightDto.getDepartureTime())
                .arrivalTime(flightDto.getArrivalTime())
                .availableSeats(flightDto.getAvailableSeats())
                .build();
    }

    public static FlightDto toDto(Flights flights){
        return FlightDto.builder()
                .id(flights.getId())
                .flightNumber(flights.getFlightNumber())
                .origin(flights.getOrigin())
                .destination(flights.getDestination())
                .departureTime(flights.getDepartureTime())
                .arrivalTime(flights.getArrivalTime())
                .availableSeats(flights.getAvailableSeats())
                .build();
    }
}
