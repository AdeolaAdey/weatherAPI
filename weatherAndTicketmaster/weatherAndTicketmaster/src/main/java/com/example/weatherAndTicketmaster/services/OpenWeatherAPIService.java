package com.example.weatherAndTicketmaster.services;
import com.example.weatherAndTicketmaster.models.weather.MyWeatherResponse;
import com.example.weatherAndTicketmaster.models.weather.OpenweatherResponseNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherAPIService {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    String API_ID = "e7dfaa0be93f795c7cd0c04126927497";




    @Autowired
    RestTemplate restTemplate;


    /**
     * Makes call to an external source to get the weather
     * @param location the location to find
     * @return the JSON response
     */

    public MyWeatherResponse callWeatherAPI(String location) {

        String url = BASE_URL + "?q=" + location +"&APPID=" + API_ID;
        OpenweatherResponseNew response =  restTemplate.getForObject(url, OpenweatherResponseNew.class);
        MyWeatherResponse myWeatherResponse = weatherData(response);

        return myWeatherResponse;

    }

    private MyWeatherResponse weatherData(OpenweatherResponseNew newWeather)  {
        MyWeatherResponse myWeatherResponse = new MyWeatherResponse();

        myWeatherResponse.setLocation(newWeather.getName());
        myWeatherResponse.setWindSpeed(newWeather.getWind().getSpeed().toString());
        myWeatherResponse.setTemperature(newWeather.getMain().getTemp().toString());
        myWeatherResponse.setHumidity(String.valueOf(newWeather.getMain().getHumidity()));



        return myWeatherResponse;
    }


}
