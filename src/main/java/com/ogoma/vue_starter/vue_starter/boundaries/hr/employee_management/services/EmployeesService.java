package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeContactAddress;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeesService {
    private final EmployeeRepository employeeRepository;

    public EmployeesService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> getEmployees(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<Employee> employees = this.employeeRepository.findAll(pageable);
        return employees;
    }

    public Employee createEmployee(EmployeeCreateModel employeeCreateModel) {
        User user = new User();
        Employee employee = new Employee();
        Set<EmployeeContactAddress> employeeContactAddresses = new HashSet<>();
        employeeCreateModel.getContactAddresses().forEach(add -> {
            EmployeeContactAddress employeeContactAddress = new EmployeeContactAddress();
            BeanUtils.copyProperties(add, employeeContactAddress);
            employeeContactAddresses.add(employeeContactAddress);
        });
        BeanUtils.copyProperties(employeeCreateModel.getBasicInfo(), user);
        BeanUtils.copyProperties(employeeCreateModel.getEmployementDetail(), employee);
        employee.setEmployeeContactAddresses(employeeContactAddresses);
        user.addStaff(employee);
        employee.setUser(user);
        this.employeeRepository.save(employee);
        return employee;
    }
}
