package com.weatherbroadcast.weather.app.api.service;

import com.weatherbroadcast.weather.app.api.dto.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BroadcastService {
    Weather getBroadcastUpdate(String city) throws Exception;
}
