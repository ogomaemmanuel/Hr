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
import java.util.Optional;

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

    public void removeTerminatedEmployee(Long id) {
        this.terminatedEmployeeRepository.deleteById(id);
    }

    public Optional<TerminatedEmployee> updateTermination(Long id, TerminatedEmployee terminatedEmployee) {
        Optional<TerminatedEmployee> terminatedEmployee1 =
                this.terminatedEmployeeRepository.findById(id);
        terminatedEmployee1.ifPresent(te -> {
            te.setNoticeDate(terminatedEmployee.getNoticeDate());
            te.setReason(terminatedEmployee.getReason());
            te.setTerminationDate(terminatedEmployee.getTerminationDate());
            te.setTerminationReasonCode(terminatedEmployee.getTerminationReasonCode());
            this.terminatedEmployeeRepository.save(te);
        });
        return terminatedEmployee1;
    }
}
