package com.example.ironbank2020.services;

import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return !name.toLowerCase().contains("stark");
    }

}
