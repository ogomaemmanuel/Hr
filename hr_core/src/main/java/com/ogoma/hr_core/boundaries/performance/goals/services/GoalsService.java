package com.ogoma.hr_core.boundaries.performance.goals.services;

import com.ogoma.hr_core.boundaries.performance.goals.entities.Goal;
import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalType;
import com.ogoma.hr_core.boundaries.performance.goals.repository.GoalRepository;
import com.ogoma.hr_core.boundaries.performance.goals.repository.GoalTypeRepository;
import com.ogoma.hr_core.boundaries.performance.goals.requests.GoalRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalsService {
    private final GoalRepository goalRepository;
    private final GoalTypeRepository goalTypeRepository;

    public GoalsService(GoalRepository goalRepository,
                        GoalTypeRepository goalTypeRepository) {
        this.goalRepository = goalRepository;
        this.goalTypeRepository = goalTypeRepository;
    }

    public List<Goal> getAllGoals() {
        return this.goalRepository.findAll();
    }
    public Page<Goal> getGoals(PagedDataRequest pagedDataRequest) {
        return this.goalRepository.findAll(pagedDataRequest.toPageable());
    }

    public Optional<Goal> getGoalByID(Long ID) {
        Optional<Goal> goalTracking = this.goalRepository.findById(ID);
        return goalTracking;
    }

    public Optional<Goal> updateGoal(Long id, GoalRequest goalRequest) {
        Optional<Goal> goal= this.goalRepository.findById(id);
        goal.ifPresent(gt -> {
            GoalType goalType = this.goalTypeRepository.getOne(goalRequest.getGoalTypeID());
            gt.setGoalType(goalType);
            gt.setDescription(goalRequest.getDescription());
            gt.setEndDate(goalRequest.getEndDate());
            gt.setStartDate(goalRequest.getStartDate());
            gt.setSubject(goalRequest.getSubject());
            this.goalRepository.save(gt);
        });
        return goal;
    }


    public Goal createGoal(GoalRequest goalRequest) {
        GoalType goalType = this.goalTypeRepository.getOne(goalRequest.getGoalTypeID());
        Goal goal = new Goal();
        goal.setGoalType(goalType);
        goal.setDescription(goalRequest.getDescription());
        goal.setEndDate(goalRequest.getEndDate());
        goal.setStartDate(goalRequest.getStartDate());
        goal.setSubject(goalRequest.getSubject());
        goal.setTargetAchievement(goalRequest.getTargetAchievement());
        this.goalRepository.save(goal);
        return goal;
    }


}
