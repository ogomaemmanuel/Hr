package com.ogoma.hr_core.boundaries.performance.goals;

import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalTracking;
import com.ogoma.hr_core.boundaries.performance.goals.requests.GoalTrackingRequest;
import com.ogoma.hr_core.boundaries.performance.goals.services.GoalTrackingService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/goal-tracking")
public class GoalTrackingController {
    private  final GoalTrackingService goalTrackingService;
    public GoalTrackingController(GoalTrackingService goalTrackingService) {
        this.goalTrackingService = goalTrackingService;
    }
    @GetMapping
    public ResponseEntity<Page<GoalTracking>> getGoalTrackings(PagedDataRequest pagedDataRequest){
        Page<GoalTracking> goalTrackings = this.goalTrackingService.getGoalTrackings(pagedDataRequest);
        return ResponseEntity.ok(goalTrackings);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGoalTrackingById(@PathVariable  Long id){
        Optional<GoalTracking> goalTracking = this.goalTrackingService.getGoalTrackingByID(id);
        return ResponseEntity.ok(goalTracking);
    }

    @PostMapping
    public ResponseEntity<?> createGoalTracking(@RequestBody @Valid GoalTrackingRequest goalTrackingRequest){
        GoalTracking goalTracking = this.goalTrackingService.createGoalTracking(goalTrackingRequest);
        return ResponseEntity.ok(goalTracking);
    }
}
