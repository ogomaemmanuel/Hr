package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation_;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.DesignationDto;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DesignationRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DesignationService {
    private final DesignationRepository designationRepository;

    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    public Page<Designation> getDesignations(PagedDataRequest pagedDataRequest) {

        Page<Designation> designations = this.designationRepository.findAll(
                 (root, criteriaQuery, criteriaBuilder) -> {
                    if(Long.class!= criteriaQuery.getResultType())
                    {
                       root.fetch(Designation_.DEPARTMENT, JoinType.LEFT);
                    }
                    return criteriaBuilder.conjunction();
                },
                pagedDataRequest.toPageable());
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

    public void removeDesignation(Long id) {
        this.designationRepository.deleteById(id);
    }

    public ByteArrayInputStream generateReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<Designation> designationList = this.designationRepository.findAll();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Designations");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Department");
        int rowId = 1;
        for (Designation designation : designationList) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(designation.getName());
            cell = row.createCell(2);
            cell.setCellValue(designation.getDepartment().getName());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }
}
