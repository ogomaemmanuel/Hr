package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminationReason;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.TerminatedEmployeeView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminatedEmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.TerminationReasonsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<TerminatedEmployeeView> getAll(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<TerminatedEmployeeView> terminatedEmployeeViews =
                this.terminatedEmployeeRepository.getAll(pageRequest);
        return terminatedEmployeeViews;
    }

    public TerminatedEmployee createTermination(TerminatedEmployee terminatedEmployee) {
        this.terminatedEmployeeRepository.save(terminatedEmployee);
        return terminatedEmployee;
    }

    public List<TerminationReason> getTerminationReasons() {
        return this.terminationReasonsRepository.findAll();
    }
}
