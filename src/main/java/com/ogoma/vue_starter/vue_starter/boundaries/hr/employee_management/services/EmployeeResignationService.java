package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeResignation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeResignationView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeResignationRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.requests.ResignationRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeResignationService {
    private final EmployeeResignationRepository employeeResignationRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeResignationService(
            EmployeeResignationRepository employeeResignationRepository, EmployeeRepository employeeRepository) {
        this.employeeResignationRepository = employeeResignationRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeResignation createEmployeeResignation(ResignationRequest
                                                                 resignationRequest) {
        Employee employee= this.employeeRepository.findById(resignationRequest.getEmployeeId()).get();
        EmployeeResignation employeeResignation = new EmployeeResignation();
        employeeResignation.setResignationDate(resignationRequest.getResignationDate());
        employeeResignation.setNoticeDate(resignationRequest.getNoticeDate());
        employeeResignation.setReason(resignationRequest.getReason());
        employeeResignation.setNoticeDate(resignationRequest.getNoticeDate());
        employeeResignation.setEmployee(employee);
        this.employeeResignationRepository.save(employeeResignation);
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
                                                                   ResignationRequest resignationRequest) {
        Optional<EmployeeResignation> employeeResignation1 = this.employeeResignationRepository.findById(id);
        employeeResignation1.ifPresent(res -> {
            res.setNoticeDate(resignationRequest.getNoticeDate());
            res.setReason(resignationRequest.getReason());
            res.setResignationDate(resignationRequest.getResignationDate());
            employeeResignationRepository.save(res);
        });
        return employeeResignation1;
    }
}
