package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.TaskStatus;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.TaskStatusCreateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.TaskStatusService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "api/task-statuses")
public class TaskStatusController {
    private final TaskStatusService taskStatusService;

    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @GetMapping
    public ResponseEntity<?> getTaskStatus(PagedDataRequest pagedDataRequest) {
        Page<TaskStatus> taskStatuses = this.taskStatusService.getTaskStatuses(pagedDataRequest);
        return ResponseEntity.ok(taskStatuses);
    }

    @PostMapping
    public ResponseEntity<?> createTaskStatus(@RequestBody @Valid TaskStatusCreateRequest taskStatusCreateRequest) {
        TaskStatus taskStatus =
                this.taskStatusService.createStatus(taskStatusCreateRequest);
        return ResponseEntity.ok(taskStatus);
    }
}
