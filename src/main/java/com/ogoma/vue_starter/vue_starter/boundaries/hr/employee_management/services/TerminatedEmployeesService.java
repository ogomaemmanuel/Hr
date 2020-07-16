package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminatedEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class TerminatedEmployeesService {
    private final TerminatedEmployeeRepository terminatedEmployeeRepository;

    public TerminatedEmployeesService(TerminatedEmployeeRepository terminatedEmployeeRepository) {
        this.terminatedEmployeeRepository = terminatedEmployeeRepository;
    }

    public TerminatedEmployee createTermination(TerminatedEmployee terminatedEmployee) {
        this.terminatedEmployeeRepository.save(terminatedEmployee);
        return terminatedEmployee;
    }
}
