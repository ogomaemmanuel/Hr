package com.ogoma.hr_core.boundaries.project_management.repositories;

import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.boundaries.project_management.entities.TaskStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends BaseRepo<TaskStatus> {
//    <T>List<T> findAllById(Long id,Class<T> tClass);
}
