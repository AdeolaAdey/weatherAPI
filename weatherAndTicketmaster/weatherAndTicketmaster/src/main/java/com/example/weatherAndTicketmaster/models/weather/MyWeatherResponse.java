package com.example.weatherAndTicketmaster.models.weather;

import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import lombok.Data;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyWeatherResponse {
    private String location;
    private String temperature;
    private String humidity;
    private String windSpeed;
    List<MyActivityResponse> activity = new ArrayList<>();

}
