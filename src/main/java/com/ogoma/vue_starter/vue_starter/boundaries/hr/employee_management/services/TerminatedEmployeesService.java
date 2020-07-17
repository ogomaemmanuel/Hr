package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminationReason;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminatedEmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminationReasonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminatedEmployeesService {
    private final TerminatedEmployeeRepository terminatedEmployeeRepository;
    private final TerminationReasonsRepository terminationReasonsRepository;

    public TerminatedEmployeesService(TerminatedEmployeeRepository terminatedEmployeeRepository,
                                      TerminationReasonsRepository terminationReasonsRepository) {
        this.terminatedEmployeeRepository = terminatedEmployeeRepository;
        this.terminationReasonsRepository = terminationReasonsRepository;
    }

    public TerminatedEmployee createTermination(TerminatedEmployee terminatedEmployee) {
        this.terminatedEmployeeRepository.save(terminatedEmployee);
        return terminatedEmployee;
    }

    public List<TerminationReason> getTerminationReasons(){
        return  this.terminationReasonsRepository.findAll();
    }
}
