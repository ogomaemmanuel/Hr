package com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.entities.GoalTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTrackingRepository  extends JpaRepository<GoalTracking, Long> {
}
