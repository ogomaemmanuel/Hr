package com.ogoma.hr_core.boundaries.performance.goals.repository;

import com.ogoma.hr_core.boundaries.performance.goals.entities.Goal;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends BaseRepo<Goal> {
}
