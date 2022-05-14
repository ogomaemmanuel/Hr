package com.ogoma.hr_core.boundaries.project_management.repositories;

import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.boundaries.project_management.entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepo<Task> {
}
