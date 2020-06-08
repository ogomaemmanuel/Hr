package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public Department createDepartment(Department department) {
        this.departmentsRepository.save(department);
        return department;
    }

    public Optional<Department> getDepartmentById(Long id) {
        Optional<Department> department = this.departmentsRepository.findById(id);
        return department;
    }

    public Page<Department> getDepartments(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<Department> departments = this.departmentsRepository.findAll(pageRequest);
        return departments;
    }

    public Optional<Department> updateDepartment(Long id, Department department) {
        Optional<Department> departmentDb = this.departmentsRepository.findById(id);
        departmentDb.ifPresent((dept) -> {
            dept.setName(department.getName());
            departmentsRepository.save(dept);
        });
        return departmentDb;
    }
}
