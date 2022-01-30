package com.ogoma.vue_starter.vue_starter.boundaries.training;

import com.ogoma.vue_starter.vue_starter.boundaries.training.entities.Trainer;
import com.ogoma.vue_starter.vue_starter.boundaries.training.requests.TrainerRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.training.services.TrainerService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class TrainersController {
    private final TrainerService trainerService;

    public TrainersController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @RequestMapping(value = "api/trainers", method = RequestMethod.POST)
    public ResponseEntity<?> createTrainer(@RequestBody @Valid TrainerRequest trainer) {
        this.trainerService.createTrainer(trainer);
        return ResponseEntity.ok(trainer);
    }

    @RequestMapping(value = "api/trainers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTrainers(PagedDataRequest pagedDataRequest) {
        Page<Trainer> trainers = this.trainerService.getTrainers(pagedDataRequest);
        return ResponseEntity.ok(trainers);
    }

    @RequestMapping(value = "api/trainers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTrainer(@PathVariable("id") Long id) {
        Optional<Trainer> trainer = this.trainerService.getTrainer(id);
        return ResponseEntity.of(trainer);
    }
    @RequestMapping(value = "api/trainers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTrainer(@PathVariable Long  id,
                                           @RequestBody @Valid  TrainerRequest trainerRequest){
        Optional<Trainer> trainer=
                this.trainerService.updateTrainer(id,trainerRequest);
        return  ResponseEntity.of(trainer);
    }


    @RequestMapping(value = "api/trainers/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTrainer(@PathVariable Long id){
        this.trainerService.removeTrainer(id);
        return ResponseEntity.ok("Trainer successfully removed");
    }
}

