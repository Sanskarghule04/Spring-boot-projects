package com.thinkitive.AirlineBooking.repository;

import com.thinkitive.AirlineBooking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}

/*
 jpa repository crud extra sorting, pagintation...etc
 crud repository crud operation...
 */