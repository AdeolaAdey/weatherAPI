package com.example.weatherAndTicketmaster.controller;

import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityControllerTest {

    @Autowired
    ActivityController activityController;

    @Test
    void whenTicketMasterAPIIsSuccessful()  {
        // given
        String location = "London";
        // when
        MyActivityResponse results = activityController.activity(location);
        // then
        assertNotNull(results);
        assertNotNull(results.getName());
//        assertNotNull(results.getLocation());
        assertNotNull(results.getType());
        assertNotNull(results.getDescription());
    }

//    @Test
//    void whenWeatherAPIIsGivesWindSpeed()  {
//        // given
//        WeatherController weatherController = new WeatherController();
//        String location = "London";
//        // when
//        MyWeatherResponse results = weatherController.weather(location);
//        // then
//        assertNotNull(results);
//    }

}