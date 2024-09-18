package com.kirana.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyConversionService {
    private final String API_URL = "https://api.fxratesapi.com/latest";

    public double convert(String fromCurrency, String toCurrency, double amount) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
        // Logic to extract rates and perform conversion
    }
}
