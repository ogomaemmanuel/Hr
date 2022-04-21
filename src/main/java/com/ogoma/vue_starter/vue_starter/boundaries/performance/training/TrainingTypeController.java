package com.ogoma.vue_starter.vue_starter.boundaries.performance.training;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.services.TrainingTypeService;
import org.springframework.stereotype.Controller;

@Controller
public class TrainingTypeController {
    private  final TrainingTypeService trainingTypeService;

    public TrainingTypeController(TrainingTypeService trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }
}
