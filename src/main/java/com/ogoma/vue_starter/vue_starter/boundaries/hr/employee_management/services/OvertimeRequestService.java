package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.OvertimeRequestView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.OvertimeRequestRepository;
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
public class OvertimeRequestService {
    private final OvertimeRequestRepository overtimeRequestRepository;

    public OvertimeRequestService(OvertimeRequestRepository overtimeRequestRepository) {
        this.overtimeRequestRepository = overtimeRequestRepository;
    }

    public Page<OvertimeRequestView> getOvertimeRequests(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<OvertimeRequestView> overtimeRequestViews = this.overtimeRequestRepository.getAllActive(pageRequest);
        return overtimeRequestViews;
    }

    public OvertimeRequest createOvertimeRequest(OvertimeRequest overtimeRequest) {
        overtimeRequest = this.overtimeRequestRepository.save(overtimeRequest);
        return overtimeRequest;
    }

    public Optional<OvertimeRequest> getOvertimeById(Long id) {
        Optional<OvertimeRequest> overtimeRequest =
                this.overtimeRequestRepository.findById(id);
        return overtimeRequest;
    }

    public Optional<OvertimeRequest> updateOvertimeRequest(Long id, OvertimeRequest overtimeRequest) {
        Optional<OvertimeRequest> overtimeRequest1 =
                this.overtimeRequestRepository.findById(id);
        overtimeRequest1.ifPresent(ovr -> {
            ovr.setDescription(overtimeRequest.getDescription());
            ovr.setOvertimeHours(overtimeRequest.getOvertimeHours());
            ovr.setOvertimeDate(overtimeRequest.getOvertimeDate());
            this.overtimeRequestRepository.save(ovr);
        });
        return overtimeRequest1;
    }

    public void removeOvertimeRequest(Long id) {
        this.overtimeRequestRepository.deleteById(id);
    }

    public ByteArrayInputStream generateReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<OvertimeRequestView> overtimeRequests = this.overtimeRequestRepository.getAllActive();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Departments");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Overtime Date");
        row.createCell(3).setCellValue("Overtime Hours");
        row.createCell(4).setCellValue("Description");
        int rowId = 1;
        for (OvertimeRequestView overtimeRequest : overtimeRequests) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(overtimeRequest.getEmployeeFullName());
            cell = row.createCell(2);
            cell.setCellValue(overtimeRequest.getOvertimeDate());
            cell = row.createCell(3);
            cell.setCellValue(overtimeRequest.getOvertimeHours());
            cell = row.createCell(4);
            cell.setCellValue(overtimeRequest.getDescription());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }
}
