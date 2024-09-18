package com.example.weatherAndTicketmaster.models.weather;

import lombok.Data;

@Data
public class OpenweatherResponseNew {
    private String name;
    private OpenweatherResponseWind wind;
    private OpenWeatherResponseMain main;

}
