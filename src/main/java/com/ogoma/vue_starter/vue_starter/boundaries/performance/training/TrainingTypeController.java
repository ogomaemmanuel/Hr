package com.ogoma.vue_starter.vue_starter.boundaries.performance.training;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities.TrainingType;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.requests.TrainingTypeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.services.TrainingTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/training-types")
public class TrainingTypeController {
    private  final TrainingTypeService trainingTypeService;

    public TrainingTypeController(TrainingTypeService trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    @PostMapping
    public ResponseEntity<?> createTrainingType(TrainingTypeRequest trainingTypeRequest){
        TrainingType trainingType=
                this.trainingTypeService.createTrainingType(trainingTypeRequest);
        return  ResponseEntity.ok(trainingType);
    }
}
