package com.ogoma.hr_core.boundaries.performance.training;

import com.ogoma.hr_core.boundaries.performance.training.entities.Training;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainingRequest;
import com.ogoma.hr_core.boundaries.performance.training.services.TrainingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public ResponseEntity<?> getTrainings(Pageable pageable) {
        Page<Training> trainingList = this.trainingService.getTrainings(pageable);
        return ResponseEntity.ok(trainingList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTrainingById(@PathVariable Long id) {
        Optional<Training> training = this.trainingService.getTrainingById(id);
        return ResponseEntity.of(training);
    }

    @PostMapping
    public ResponseEntity<?> createTraining(@RequestBody @Valid TrainingRequest trainingRequest) {
        Training training =
                this.trainingService.createTraining(trainingRequest);
        return ResponseEntity.ok(training);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable Long id, @RequestBody @Valid TrainingRequest trainingRequest) {
        Optional<Training> training =
                this.trainingService.updateTrainingById(id, trainingRequest);
        return ResponseEntity.of(training);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTraining(@PathVariable Long id){
        this.trainingService.removeTraining(id);
        return ResponseEntity.noContent().build();
    }
}
