package com.example.ironbank2020.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.example.ironbank2020.constans.Profiles.WINTER_IS_COMING;

@Service
@Profile(WINTER_IS_COMING)
public class PredictionServiceImpl implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return !name.toLowerCase().contains("stark");
    }

}
