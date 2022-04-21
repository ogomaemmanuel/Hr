package com.ogoma.vue_starter.vue_starter.boundaries.performance.training.services;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.repository.TrainingTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingTypeService {
    private final TrainingTypeRepository trainingTypeRepository;
    public TrainingTypeService(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }
}
