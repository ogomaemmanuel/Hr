package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.TaskCreateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ProjectsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.TaskRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.web_queries.TaskFilterQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectsRepository projectsRepository;
    private final EmployeeRepository employeeRepository;

    public TaskService(TaskRepository taskRepository,
                       ProjectsRepository projectsRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.projectsRepository = projectsRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Task> getAllTask(TaskFilterQuery taskFilterQuery) {
        List<Task> tasks = this.taskRepository.findAll(taskFilterQuery.taskSpecification());
        return tasks;
    }

    public Optional<Task> getTaskById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id);
        return task;
    }

    public Task createTask(TaskCreateRequest taskCreateRequest) {
        Task task = new Task();
        List<Employee> employees = this.employeeRepository.findAllById(taskCreateRequest.getAssignedEmployeesId());
        task.setAssignedEmployees(employees);
        convertToEntity(taskCreateRequest, task);
        return task;
    }

    public Optional<Task> updateTask(Long id, TaskCreateRequest taskCreateRequest) {
        Optional<Task> task =
                this.taskRepository.findById(id);
        task.ifPresent(taskToUpdate -> {
            convertToEntity(taskCreateRequest, taskToUpdate);
            this.taskRepository.save(taskToUpdate);
        });
        return task;
    }

    private void convertToEntity(TaskCreateRequest taskCreateRequest, Task task) {
        Optional<Project> project = this.projectsRepository.findById(taskCreateRequest.getProjectId());
        task.setTitle(taskCreateRequest.getTitle());
        task.setDescription(taskCreateRequest.getDescription());
        project.ifPresent(taskProject -> {
            task.setProject(taskProject);
        });
    }
}
