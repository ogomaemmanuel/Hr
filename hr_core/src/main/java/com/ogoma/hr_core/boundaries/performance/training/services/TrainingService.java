package com.ogoma.hr_core.boundaries.performance.training.services;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.hr_core.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.hr_core.boundaries.performance.training.entities.Trainer;
import com.ogoma.hr_core.boundaries.performance.training.entities.Training;
import com.ogoma.hr_core.boundaries.performance.training.entities.TrainingType;
import com.ogoma.hr_core.boundaries.performance.training.repository.TrainersRepository;
import com.ogoma.hr_core.boundaries.performance.training.repository.TrainingRepository;
import com.ogoma.hr_core.boundaries.performance.training.repository.TrainingTypeRepository;
import com.ogoma.hr_core.boundaries.performance.training.requests.TrainingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final TrainingTypeRepository trainingTypeRepository;
    private final TrainersRepository trainersRepository;
    private final EmployeeRepository employeeRepository;

    public TrainingService(TrainingRepository trainingRepository,
                           TrainingTypeRepository trainingTypeRepository,
                           TrainersRepository trainersRepository,
                           EmployeeRepository employeeRepository) {
        this.trainingRepository = trainingRepository;
        this.trainingTypeRepository = trainingTypeRepository;
        this.trainersRepository = trainersRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Training> getTrainings() {
        List<Training> trainings = this.trainingRepository.findAll();
        return trainings;
    }

    public Optional<Training> getTrainingById(Long id) {
        Optional<Training> training = this.trainingRepository.findById(id);
        return training;
    }

    public Training createTraining(TrainingRequest trainingRequest) {
        Training training = new Training();
        updateTraining(training, trainingRequest);
        this.trainingRepository.save(training);
        return training;
    }

    public Optional<Training> updateTrainingById(Long id, TrainingRequest trainingRequest) {
        Optional<Training> training = this.trainingRepository.findById(id);
        training.ifPresent(tr -> {
            updateTraining(tr, trainingRequest);
            trainingRepository.save(tr);
        });
        return training;
    }

    private void updateTraining(Training training, TrainingRequest trainingRequest) {
        TrainingType trainingType = this.trainingTypeRepository.getOne(trainingRequest.getTrainingTypeId());
        Trainer trainer = this.trainersRepository.getOne(trainingRequest.getTrainerId());
        Employee employee = this.employeeRepository.getOne(trainingRequest.getEmployeeId());
        training.setCost(trainingRequest.getCost());
        training.setStartDate(trainingRequest.getStartDate());
        training.setEndDate(trainingRequest.getEndDate());
        training.setCost(trainingRequest.getCost());
        training.setTrainingType(trainingType);
        training.setTrainer(trainer);
        training.addEmployee(employee);
    }
}
