package com.example.weatherAndTicketmaster.models.activity;

import lombok.Data;

import java.util.List;

@Data
public class ActivityEmbedded {

    private List<ActivityEvents> events;
}
