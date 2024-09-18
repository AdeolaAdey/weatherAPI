package com.example.weatherAndTicketmaster.controller;

import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import com.example.weatherAndTicketmaster.models.weather.MyWeatherResponse;
import com.example.weatherAndTicketmaster.services.OpenWeatherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WeatherActivityController {

    @Autowired
    OpenWeatherAPIService openWeatherAPIService;
    RestTemplate restTemplate;



    @GetMapping("/weather_activity")
    public MyWeatherResponse weatheractivityResponse(@RequestParam String location){

        MyWeatherResponse myWeatherResponse = this.openWeatherAPIService.callWeatherAPI(location);
        List activity = restTemplate.getForObject("http://localhost:8081/activity?location=" + location, List.class);
        myWeatherResponse.setActivity(activity);
        return new MyWeatherResponse();
    }
}
