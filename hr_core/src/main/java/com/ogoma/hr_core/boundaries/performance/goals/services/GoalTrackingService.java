package com.ogoma.hr_core.boundaries.performance.goals.services;

import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalTracking;
import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalType;
import com.ogoma.hr_core.boundaries.performance.goals.repository.GoalTrackingRepository;
import com.ogoma.hr_core.boundaries.performance.goals.repository.GoalTypeRepository;
import com.ogoma.hr_core.boundaries.performance.goals.requests.GoalTrackingRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalTrackingService {
    private final GoalTrackingRepository goalTrackingRepository;
    private final GoalTypeRepository goalTypeRepository;

    public GoalTrackingService(GoalTrackingRepository goalTrackingRepository,
                               GoalTypeRepository goalTypeRepository) {
        this.goalTrackingRepository = goalTrackingRepository;
        this.goalTypeRepository = goalTypeRepository;
    }

    public List<GoalTracking> getAllGoalTrackings() {
        return this.goalTrackingRepository.findAll();
    }
    public Page<GoalTracking> getGoalTrackings(PagedDataRequest pagedDataRequest) {
        return this.goalTrackingRepository.findAll(pagedDataRequest.toPageable());
    }

    public Optional<GoalTracking> getGoalTrackingByID(Long ID) {
        Optional<GoalTracking> goalTracking = this.goalTrackingRepository.findById(ID);
        return goalTracking;
    }

    public Optional<GoalTracking> updateGoalTracking(Long id, GoalTrackingRequest goalTrackingRequest) {
        Optional<GoalTracking> goalTracking = this.goalTrackingRepository.findById(id);
        goalTracking.ifPresent(gt -> {
            GoalType goalType = this.goalTypeRepository.getOne(goalTrackingRequest.getGoalTypeID());
            gt.setGoalType(goalType);
            gt.setDescription(goalTrackingRequest.getDescription());
            gt.setEndDate(goalTrackingRequest.getEndDate());
            gt.setStartDate(goalTrackingRequest.getStartDate());
            gt.setSubject(goalTrackingRequest.getSubject());
            this.goalTrackingRepository.save(gt);
        });
        return goalTracking;
    }


    public GoalTracking createGoalTracking(GoalTrackingRequest goalTrackingRequest) {
        GoalType goalType = this.goalTypeRepository.getOne(goalTrackingRequest.getGoalTypeID());
        GoalTracking goalTracking = new GoalTracking();
        goalTracking.setGoalType(goalType);
        goalTracking.setDescription(goalTrackingRequest.getDescription());
        goalTracking.setEndDate(goalTrackingRequest.getEndDate());
        goalTracking.setStartDate(goalTrackingRequest.getStartDate());
        goalTracking.setSubject(goalTrackingRequest.getSubject());
        this.goalTrackingRepository.save(goalTracking);
        return goalTracking;
    }


}
