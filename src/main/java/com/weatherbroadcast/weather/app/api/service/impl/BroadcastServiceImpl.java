package com.weatherbroadcast.weather.app.api.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherbroadcast.weather.app.api.dto.Weather;
import com.weatherbroadcast.weather.app.api.service.BroadcastService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BroadcastServiceImpl implements BroadcastService {
    @Override
    public ResponseEntity<Weather> getBroadcastUpdate(String city) {
        String url = "http://api.weatherapi.com/v1/current.json?key=d552bebfbf824377a3f71630241008&q="+city+"&aqi=no";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;

        try{
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Weather data = createResponse(response);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(response);
        return null;
    }

    private Weather createResponse(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        String cityName = node.get("location").get("name").asText();
        float temp = node.get("current").get("temp_c").floatValue();
        return new Weather(cityName, temp);
    }
}
