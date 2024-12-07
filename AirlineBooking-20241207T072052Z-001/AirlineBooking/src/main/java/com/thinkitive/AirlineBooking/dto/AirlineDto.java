package com.thinkitive.AirlineBooking.dto;

import com.thinkitive.AirlineBooking.entity.Flights;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDto {

    private int id;

    @NotBlank(message = "Airline Name is required")
    private String name;

    @NotBlank(message = "Country name is required")
    private String country;

    @NotEmpty(message = "At least one Flight is required")
    private List<FlightDto> flights;
}
