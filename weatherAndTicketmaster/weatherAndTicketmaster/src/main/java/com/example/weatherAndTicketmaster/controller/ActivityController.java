package com.example.weatherAndTicketmaster.controller;

import com.example.weatherAndTicketmaster.models.activity.MyActivityResponse;
import com.example.weatherAndTicketmaster.services.TicketMasterAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController{

    @Autowired
    TicketMasterAPIService ticketMasterAPIService;



    @GetMapping("/activity")
    public MyActivityResponse activity(@RequestParam String location) {

        return ticketMasterAPIService.callTicketMasterAPI(location);
    }
}
