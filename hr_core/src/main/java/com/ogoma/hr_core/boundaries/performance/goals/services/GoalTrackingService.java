package com.ogoma.hr_core.boundaries.performance.goals.services;

import com.ogoma.hr_core.boundaries.performance.goals.repository.GoalTrackingRepository;
import org.springframework.stereotype.Service;

@Service
public class GoalTrackingService {
    private final GoalTrackingRepository goalTrackingRepository;
    public GoalTrackingService(GoalTrackingRepository goalTrackingRepository) {
        this.goalTrackingRepository = goalTrackingRepository;
    }


}
