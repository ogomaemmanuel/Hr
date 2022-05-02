package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepo<Task> {
}
