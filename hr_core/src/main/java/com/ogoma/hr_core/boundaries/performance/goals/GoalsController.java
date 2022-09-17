package com.ogoma.hr_core.boundaries.performance.goals;

import com.ogoma.hr_core.boundaries.performance.goals.entities.Goal;
import com.ogoma.hr_core.boundaries.performance.goals.requests.GoalRequest;
import com.ogoma.hr_core.boundaries.performance.goals.services.GoalsService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/goals")
public class GoalsController {
    private  final GoalsService goalsService;
    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }
    @GetMapping
    public ResponseEntity<Page<Goal>> getGoal(PagedDataRequest pagedDataRequest){
        Page<Goal> goals = this.goalsService.getGoals(pagedDataRequest);
        return ResponseEntity.ok(goals);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGoalById(@PathVariable  Long id){
        Optional<Goal> goalTracking = this.goalsService.getGoalByID(id);
        return ResponseEntity.ok(goalTracking);
    }

    @PostMapping
    public ResponseEntity<?> createGoal(@RequestBody @Valid GoalRequest goalRequest){
        Goal goal = this.goalsService.createGoal(goalRequest);
        return ResponseEntity.ok(goal);
    }


}
