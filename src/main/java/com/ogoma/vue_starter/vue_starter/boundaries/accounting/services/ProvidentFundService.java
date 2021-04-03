package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.ProvidentFund;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.ProvidentFund_;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.ProvidentFundRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.ProvidentFundRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee_;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
//import org.hibernate.sql.JoinType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.JoinTable;
import javax.persistence.criteria.JoinType;

import java.util.Optional;

@Service
public class ProvidentFundService {
    private final ProvidentFundRepository providentFundRepository;
    private final EmployeeRepository employeeRepository;

    public ProvidentFundService(ProvidentFundRepository providentFundRepository, EmployeeRepository employeeRepository) {
        this.providentFundRepository = providentFundRepository;
        this.employeeRepository = employeeRepository;
    }

    public Page<ProvidentFund> getProvidentFunds(PagedDataRequest pagedDataRequest) {
        Page<ProvidentFund> providentFunds =
                this.providentFundRepository.findAll(
                        (root, criteriaQuery, criteriaBuilder) -> {
                            if (Long.class != criteriaQuery.getResultType()) {
                                root.fetch(ProvidentFund_.EMPLOYEE, JoinType.LEFT)
                                        .fetch(Employee_.USER, JoinType.LEFT);
                            } else {
                                root.join(ProvidentFund_.EMPLOYEE, JoinType.LEFT)
                                        .join(Employee_.USER, JoinType.LEFT);
                            }
                            return criteriaBuilder.conjunction();
                        },
                        pagedDataRequest.toPageable());
        return providentFunds;
    }

    public ProvidentFund createProvidentFund(ProvidentFundRequest providentFundRequest) {
        ProvidentFund providentFund = new ProvidentFund();
        Employee employee = this.employeeRepository.getOne(providentFundRequest.getEmployeeId());
        providentFund.setDescription(providentFundRequest.getDescription());
        providentFund.setEmployeeShare(providentFundRequest.getEmployeeShare());
        providentFund.setProvidentFundType(providentFundRequest.getProvidentFundType());
        providentFund.setOrganisationShare(providentFundRequest.getOrganisationShare());
        providentFund.setPercentageEmployeeShare(providentFundRequest.getPercentageEmployeeShare());
        providentFund.setPercentageOrganisationShare(providentFundRequest.getPercentageOrganisationShare());
        providentFund.setEmployee(employee);
        this.providentFundRepository.save(providentFund);
        return providentFund;
    }


    public Optional<ProvidentFund> updateProvidentFund(Long id, ProvidentFundRequest providentFundRequest) {
        Optional<ProvidentFund> providentFund =
                this.providentFundRepository.findById(id);
        Employee employee = this.employeeRepository.getOne(providentFundRequest.getEmployeeId());
        providentFund.ifPresent(p -> {
            p.setEmployee(employee);
            p.setPercentageOrganisationShare(providentFundRequest.getPercentageOrganisationShare());
            p.setPercentageEmployeeShare(providentFundRequest.getPercentageEmployeeShare());
            p.setDescription(providentFundRequest.getDescription());
            p.setProvidentFundType(providentFundRequest.getProvidentFundType());
            p.setEmployeeShare(providentFundRequest.getEmployeeShare());
            p.setOrganisationShare(providentFundRequest.getOrganisationShare());
            this.providentFundRepository.save(p);
        });
        return providentFund;
    }

    public Optional<ProvidentFund> getProvidentFundById(Long id) {
        Optional<ProvidentFund> providentFund = this.providentFundRepository.findById(id);
        return providentFund;
    }
}
