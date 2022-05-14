package com.ogoma.hr_core.boundaries.project_management.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.OneToMany;

public class ProjectMember {
    @OneToMany
    private Project project;
    @OneToMany
    private Employee employee;
}
