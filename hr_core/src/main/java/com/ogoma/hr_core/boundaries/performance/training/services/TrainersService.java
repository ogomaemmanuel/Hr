package com.ogoma.hr_core.boundaries.performance.training.services;

import com.ogoma.hr_core.boundaries.performance.training.entities.Trainer;
import com.ogoma.hr_core.boundaries.performance.training.repository.TrainersRepository;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainersService {
    private final TrainersRepository trainersRepository;

    public TrainersService(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    public Page<Trainer> getAllTrainers(Pageable pageable) {
        Page<Trainer> trainers = this.trainersRepository.findAll(pageable);
        return trainers;
    }

    public Trainer createTrainer(TrainerRequest trainerRequest) {
        Trainer trainer = new Trainer();
        trainer.setDescription(trainerRequest.getDescription());
        trainer.setEmail(trainerRequest.getEmail());
        trainer.setFirstName(trainerRequest.getFirstName());
        trainer.setLastName(trainerRequest.getLastName());
        trainer.setPhone(trainerRequest.getPhone());
        trainer.setStatus(trainerRequest.getStatus());
        trainer.setRole(trainerRequest.getRole());
        this.trainersRepository.save(trainer);
        return trainer;
    }

    public Optional<Trainer> getTrainerById(Long id) {
        Optional<Trainer> trainer = this.trainersRepository.findById(id);
        return trainer;
    }

    public Optional<Trainer> updateTrainer(Long id, TrainerRequest trainerRequest) {
        Optional<Trainer> trainer = this.trainersRepository.findById(id);
        trainer.ifPresent(tr -> {
            tr.setRole(trainerRequest.getRole());
            tr.setStatus(trainerRequest.getStatus());
            tr.setLastName(trainerRequest.getLastName());
            tr.setFirstName(trainerRequest.getFirstName());
            tr.setEmail(trainerRequest.getEmail());
            tr.setPhone(trainerRequest.getPhone());
            tr.setDescription(trainerRequest.getDescription());
            this.trainersRepository.save(tr);
        });
        return trainer;
    }

}

