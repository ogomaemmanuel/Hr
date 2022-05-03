package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.TaskStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskStatusRepository extends BaseRepo<TaskStatus> {
//    <T>List<T> findAllById(Long id,Class<T> tClass);
}
