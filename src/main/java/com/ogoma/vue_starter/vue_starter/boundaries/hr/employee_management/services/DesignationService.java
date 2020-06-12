package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.DesignationDto;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DesignationRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesignationService {
    private final DesignationRepository designationRepository;

    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    public Page<Designation> getDesignations(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(
                pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize()
        );
        Page<Designation> designations = this.designationRepository.findAll(pageRequest);
        return designations;
    }

    public Optional<Designation> getDesignationById(Long id) {
        Optional<Designation> designation = this.designationRepository.findById(id);
        return designation;
    }

    public Designation createDesignation(DesignationDto designationDto) {
        Designation designation = new Designation();
        BeanUtils.copyProperties(designationDto, designation);
        this.designationRepository.save(designation);
        return designation;
    }

    public Optional<Designation> updateDesignation(Long id, DesignationDto updateRequest) {
        Optional<Designation> designationDb = this.designationRepository.findById(id);
        designationDb.ifPresent((des) -> {
            des.setName(updateRequest.getName());
            des.setDepartmentId(updateRequest.getDepartmentId());
            this.designationRepository.save(des);
        });
        return designationDb;
    }
}
