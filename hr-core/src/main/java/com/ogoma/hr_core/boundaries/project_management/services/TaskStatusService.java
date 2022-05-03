package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.TaskStatus;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.TaskStatusCreateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.TaskStatusRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;

    public TaskStatusService(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    public TaskStatus createStatus(TaskStatusCreateRequest taskStatusCreateRequest) {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setName(taskStatusCreateRequest.getName());
        this.taskStatusRepository.save(taskStatus);
        return taskStatus;
    }

    public Page<TaskStatus> getTaskStatuses(PagedDataRequest pagedDataRequest) {
        Page<TaskStatus> taskStatuses = this.taskStatusRepository.findAll(pagedDataRequest.toPageable());
        return taskStatuses;
    }
    public Optional<TaskStatus> updateTaskStatus(Long id, TaskStatusCreateRequest taskStatusCreateRequest) {
        Optional<TaskStatus> taskStatus = this.taskStatusRepository.findById(id);
        taskStatus.ifPresent(taskStatusToUpdate -> {
            taskStatusToUpdate.setName(taskStatusCreateRequest.getName());
            this.taskStatusRepository.save(taskStatusToUpdate);
        });
        return taskStatus;
    }
}
