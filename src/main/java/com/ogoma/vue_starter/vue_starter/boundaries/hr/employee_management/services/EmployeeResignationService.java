package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeResignation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeResignationView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeResignationRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeResignationService {
    private final EmployeeResignationRepository employeeResignationRepository;

    public EmployeeResignationService(
            EmployeeResignationRepository employeeResignationRepository) {
        this.employeeResignationRepository = employeeResignationRepository;
    }

    public EmployeeResignation createEmployeeResignation(EmployeeResignation
                                                                 employeeResignation) {
        employeeResignation = this.employeeResignationRepository.save(employeeResignation);
        return employeeResignation;
    }

    public Page<EmployeeResignationView> getEmployeeResignations(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<EmployeeResignationView> employeeResignationViews = this.employeeResignationRepository.getAll(pageRequest);
        return employeeResignationViews;
    }

    @Transactional
    public Optional<EmployeeResignation> getEmployeeResignationById(Long id) {
        Optional<EmployeeResignation> employeeResignation =
                this.employeeResignationRepository.getResignationById(id);
        return employeeResignation;
    }

    public void removeEmployeeResignation(Long id) {
        this.employeeResignationRepository.deleteById(id);
    }

    public Optional<EmployeeResignation> updateEmployeeResignation(Long id,
                                                                   EmployeeResignation employeeResignation) {
        Optional<EmployeeResignation> employeeResignation1 = this.employeeResignationRepository.findById(id);
        employeeResignation1.ifPresent(res -> {
            res.setNoticeDate(employeeResignation.getNoticeDate());
            res.setReason(employeeResignation.getReason());
            res.setResignationDate(employeeResignation.getResignationDate());
            employeeResignationRepository.save(res);
        });
        return employeeResignation1;
    }
}
