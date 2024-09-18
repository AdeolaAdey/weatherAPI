package com.example.weatherAndTicketmaster.controller;

import com.example.weatherAndTicketmaster.models.weather.MyWeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WeatherControllerTest {
    @Autowired
    WeatherController weatherController;

    @Test
    void whenWeatherAPIIsSuccessful()  {
        // given
        String location = "London";
        // when
       MyWeatherResponse results = weatherController.weather(location);
        // then
        assertNotNull(results);
        assertNotNull(results.getWindSpeed());
        assertNotNull(results.getLocation());
        assertNotNull(results.getTemperature());
        assertNotNull(results.getHumidity());
    }


    @Test
    void whenWeatherAPIIsSuccessfulWeatherResponse() throws JsonProcessingException {
        // given

        // when
        MyWeatherResponse results = weatherController.weather("Berlin");
        // then
        assertEquals("Berlin", results.getLocation());
    }


}