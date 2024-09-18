package com.example.weatherAndTicketmaster.services;

import com.example.weatherAndTicketmaster.models.activity.ActivityNew;
import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketMasterAPIService {


    @Autowired
    RestTemplate restTemplate;


    public MyActivityResponse callTicketMasterAPI(String location) {

        String url= "https://app.ticketmaster.com/discovery/v2/events.json?apikey=KVHSikplJ3VvwGRSKmS6uIztpgivF8co&keyword=theatre&city=" + location;
        ActivityNew response = restTemplate.getForObject(url, ActivityNew.class);
        MyActivityResponse myActivityResponse = activityAPIData(response);
          return myActivityResponse;

    }

    private MyActivityResponse activityAPIData(ActivityNew newActivity){

        MyActivityResponse myActivityResponse = new MyActivityResponse();
        myActivityResponse.setName(newActivity.get_embedded().getEvents().get(0).getName());
        myActivityResponse.setType(newActivity.get_embedded().getEvents().get(1).getType());
        myActivityResponse.setDescription(newActivity.get_embedded().getEvents().get(0).getPromoter().getDescription());
        return myActivityResponse;
    }
}
