package com.ogoma.hr_core.boundaries.performance.training;

import com.ogoma.hr_core.boundaries.performance.training.entities.Trainer;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainerRequest;
import com.ogoma.hr_core.boundaries.performance.training.services.TrainersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/trainers")
public class TrainersController {
    private final TrainersService trainersService;
    public TrainersController(TrainersService trainersService) {
        this.trainersService = trainersService;
    }
    @GetMapping
    public ResponseEntity<?> getTrainers(){
     List<Trainer> trainers  = this.trainersService.getAllTrainers();
     return ResponseEntity.ok(trainers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainerById(@PathVariable Long id){
        Optional<Trainer> trainer=
                this.trainersService.getTrainerById(id);
        return ResponseEntity.of(trainer);
    }
    @PostMapping
    public ResponseEntity<?> createTrainer(@Valid @RequestBody TrainerRequest  trainerRequest){
        Trainer trainer=
                this.trainersService.createTrainer(trainerRequest);
        return  ResponseEntity.ok(trainer);
    }

    @PutMapping("/id")
    public ResponseEntity<?> updateTrainer(@PathVariable  Long id, @RequestBody TrainerRequest trainerRequest){
       Optional<Trainer> trainer=
               this.trainersService.updateTrainer(id, trainerRequest);
       return  ResponseEntity.of(trainer);
    }
}
