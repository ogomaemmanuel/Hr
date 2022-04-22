package com.ogoma.vue_starter.vue_starter.boundaries.performance.training.services;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities.TrainingType;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.repository.TrainingTypeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.requests.TrainingTypeRequest;
import org.springframework.stereotype.Service;

@Service
public class TrainingTypeService {
    private final TrainingTypeRepository trainingTypeRepository;

    public TrainingTypeService(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }
    public TrainingType createTrainingType(TrainingTypeRequest trainingTypeRequest) {
        TrainingType trainingType = new TrainingType();
        trainingType.setType(trainingTypeRequest.getType());
        trainingType.setDescription(trainingTypeRequest.getDescription());
        trainingType.setStatus(trainingTypeRequest.getStatus());
        this.trainingTypeRepository.save(trainingType);
        return trainingType;
    }
}
