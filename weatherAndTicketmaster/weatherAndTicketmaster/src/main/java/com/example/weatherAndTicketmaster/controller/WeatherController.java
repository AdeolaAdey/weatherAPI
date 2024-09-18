package com.example.weatherAndTicketmaster.controller;

import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import com.example.weatherAndTicketmaster.models.weather.MyWeatherResponse;
import com.example.weatherAndTicketmaster.services.OpenWeatherAPIService;
import com.example.weatherAndTicketmaster.services.TicketMasterAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private OpenWeatherAPIService openWeatherAPIService;


    @GetMapping("/weather")
    public MyWeatherResponse weather(@RequestParam String location)  {

       // String weatherJSON = openWeatherAPIService.callWeatherAPI(location);
       // MyWeatherResponse myWeatherResponse = new MyWeatherResponse();


        // call weather api to get the actual weather
        // map weatherJSON onto my model
        return openWeatherAPIService.callWeatherAPI(location);

        //make the call to Open weather API to get weather
    }


}
