package com.ogoma.hr_core.boundaries.performance.training;

import com.ogoma.hr_core.boundaries.performance.training.entities.TrainingType;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainingTypeRequest;
import com.ogoma.hr_core.boundaries.performance.training.services.TrainingTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> getTrainingTypes(Pageable pageable) {
        Page<TrainingType> trainingTypeList =
                this.trainingTypeService.getTrainingTypes(pageable);
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
    public ResponseEntity<?> createTrainingType(@RequestBody @Valid TrainingTypeRequest trainingTypeRequest) {
        TrainingType trainingType =
                this.trainingTypeService.createTrainingType(trainingTypeRequest);
        return ResponseEntity.ok(trainingType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTrainingType(@PathVariable  Long id){
        this.trainingTypeService.removeTrainingType(id);
        return ResponseEntity.ok().build();
    }
}
