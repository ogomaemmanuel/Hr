package com.ogoma.vue_starter.vue_starter.boundaries.training.services;

import com.ogoma.vue_starter.vue_starter.boundaries.training.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
}
