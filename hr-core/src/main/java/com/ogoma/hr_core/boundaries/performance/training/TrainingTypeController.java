package com.ogoma.vue_starter.vue_starter.boundaries.performance.training;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities.TrainingType;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.requests.TrainingTypeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.services.TrainingTypeService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/training-types")
public class TrainingTypeController {
    private final TrainingTypeService trainingTypeService;
    public TrainingTypeController(TrainingTypeService trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }
    @GetMapping
    public ResponseEntity<?> getTrainingTypes() {
        List<TrainingType> trainingTypeList =
                this.trainingTypeService.getTrainingTypes();
        return ResponseEntity.ok(trainingTypeList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainingTypeById(@PathVariable Long id){
        Optional<TrainingType> trainingType=
                this.trainingTypeService.getTrainingTypeById(id);
        return ResponseEntity.of(trainingType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrainingType(@PathVariable Long id,
                                                @RequestBody TrainingTypeRequest trainingTypeRequest){
     Optional<TrainingType> trainingType= this.trainingTypeService.updateTrainingType( id, trainingTypeRequest);
     return ResponseEntity.of(trainingType);
    }
    @PostMapping
    public ResponseEntity<?> createTrainingType(@RequestBody TrainingTypeRequest trainingTypeRequest) {
        TrainingType trainingType =
                this.trainingTypeService.createTrainingType(trainingTypeRequest);
        return ResponseEntity.ok(trainingType);
    }
}
