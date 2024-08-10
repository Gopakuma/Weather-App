package com.weatherbroadcast.weather.app.api.controller;

import com.weatherbroadcast.weather.app.api.dto.Weather;
import com.weatherbroadcast.weather.app.api.service.impl.BroadcastServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Broadcast {

    @Autowired
    BroadcastServiceImpl broadcastService;

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.GET)
    public ResponseEntity<Weather> getWeather(@PathVariable String city) {
        return broadcastService.getBroadcastUpdate(city);
    }
}
