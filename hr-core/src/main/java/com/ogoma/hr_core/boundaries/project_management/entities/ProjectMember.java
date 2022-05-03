package com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.OneToMany;

public class ProjectMember {
    @OneToMany
    private Project project;
    @OneToMany
    private Employee employee;
}
