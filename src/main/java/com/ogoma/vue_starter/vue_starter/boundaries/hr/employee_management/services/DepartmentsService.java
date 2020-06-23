package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public Department createDepartment(Department department) {
        this.departmentsRepository.save(department);
        return department;
    }

    public Optional<Department> getDepartmentById(Long id) {
        Optional<Department> department = this.departmentsRepository.findById(id);
        return department;
    }

    public Page<Department> getDepartments(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<Department> departments = this.departmentsRepository.findAllByDeletedFalse(pageRequest);
        return departments;
    }

    public Optional<Department> updateDepartment(Long id, Department department) {
        Optional<Department> departmentDb = this.departmentsRepository.findById(id);
        departmentDb.ifPresent((dept) -> {
            dept.setName(department.getName());
            departmentsRepository.save(dept);
        });
        return departmentDb;
    }

    public void removeDepartment(Long id) {
        this.departmentsRepository.deleteById(id);
    }

    public ByteArrayInputStream generateReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<Department> departmentList = this.departmentsRepository.findAll();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Departments");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
        int rowId = 1;
        for (Department department : departmentList) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(department.getName());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }
}
