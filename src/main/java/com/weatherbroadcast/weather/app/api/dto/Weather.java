package com.weatherbroadcast.weather.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String cityName;
    private float temp;
    private String region;
    private String countryName;
    private String dateTime;
    private String condition;
    private String icon;
    private float humidity;
    private float feelsLike;
}
