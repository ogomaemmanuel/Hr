package com.ogoma.hr_core.boundaries.performance.training.services;

import com.ogoma.hr_core.boundaries.performance.training.entities.TrainingType;
import com.ogoma.hr_core.boundaries.performance.training.repository.TrainingTypeRepository;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainingTypeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<TrainingType> getTrainingTypes(Pageable pageable) {
        Page<TrainingType> trainingTypeList =
                this.trainingTypeRepository.findAll(pageable);
        return trainingTypeList;
    }

    public Optional<TrainingType> updateTrainingType(Long id, TrainingTypeRequest trainingTypeRequest) {
        Optional<TrainingType> trainingType =
                this.trainingTypeRepository.findById(id);
        trainingType.ifPresent(tType -> {
            tType.setStatus(trainingTypeRequest.getStatus());
            tType.setDescription(trainingTypeRequest.getDescription());
            tType.setType(trainingTypeRequest.getType());
            this.trainingTypeRepository.save(tType);
        });
        return trainingType;
    }

    public Optional<TrainingType> getTrainingTypeById(Long id) {
        Optional<TrainingType> trainingType =
                this.trainingTypeRepository.findById(id);
        return trainingType;
    }
    public void removeTrainingType(Long id) {
        this.trainingTypeRepository.deleteById(id);
    }
}
