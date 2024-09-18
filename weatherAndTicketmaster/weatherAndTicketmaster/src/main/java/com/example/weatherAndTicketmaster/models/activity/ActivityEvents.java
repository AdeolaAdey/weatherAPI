package com.example.weatherAndTicketmaster.models.activity;

import lombok.Data;

@Data
public class ActivityEvents {
    private String name;
    private String type;
    private ActivityDescription promoter;
}
