package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.TaskCreateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.TaskService;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.web_queries.TaskFilterQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/tasks")
public class TasksController {
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<?> getTasks(TaskFilterQuery taskFilterQuery) {
        List<Task> tasks =
                this.taskService.getAllTask(taskFilterQuery);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Optional<Task> task = this.taskService.getTaskById(id);
        return ResponseEntity.of(task);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskCreateRequest taskCreateRequest) {
        Task task = this.taskService.createTask(taskCreateRequest);
        return ResponseEntity.ok(task);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody @Valid TaskCreateRequest taskCreateRequest) {
        Optional<Task> task = this.taskService.updateTask(id, taskCreateRequest);
        return ResponseEntity.of(task);
    }

}
