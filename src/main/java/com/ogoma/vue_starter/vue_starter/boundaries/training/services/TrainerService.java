package com.ogoma.vue_starter.vue_starter.boundaries.training.services;

import com.ogoma.vue_starter.vue_starter.boundaries.training.entities.Trainer;
import com.ogoma.vue_starter.vue_starter.boundaries.training.repositories.TrainersRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.training.requests.TrainerRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerService {
    private final TrainersRepository trainersRepository;

    public TrainerService(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    public Trainer createTrainer(TrainerRequest trainerRequest) {
        Trainer trainer = new Trainer();
        trainer.setEmail(trainerRequest.getDescription());
        trainer.setLastName(trainerRequest.getLastName());
        trainer.setFirstName(trainerRequest.getFirstName());
        trainer.setRole(trainerRequest.getRole());
        trainer.setDescription(trainerRequest.getDescription());
        trainer.setStatus(trainerRequest.getStatus());
        this.trainersRepository.save(trainer);
        return trainer;
    }

    public Page<Trainer> getTrainers(PagedDataRequest pagedDataRequest) {
        Page<Trainer> trainers =
                this.trainersRepository.findAll(pagedDataRequest.toPageable());
        return trainers;
    }

    public Optional<Trainer> getTrainer(Long id) {
        Optional<Trainer> trainer = this.trainersRepository.findById(id);
        return trainer;
    }

    public void removeTrainer(Long id) {
        this.trainersRepository.deleteById(id);
    }

    public Optional<Trainer> updateTrainer(Long id, TrainerRequest trainerRequest) {
        Optional<Trainer> trainer = this.trainersRepository.findById(id);
        trainer.ifPresent(t -> {
            t.setDescription(trainerRequest.getDescription());
            t.setEmail(trainerRequest.getDescription());
            t.setLastName(trainerRequest.getLastName());
            t.setFirstName(trainerRequest.getFirstName());
            t.setRole(trainerRequest.getRole());
            t.setStatus(trainerRequest.getStatus());
            this.trainersRepository.save(t);
        });
        return trainer;
    }
}

