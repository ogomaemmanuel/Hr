package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Permission;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PermissionsRepository;
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

@Service
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;
    public PermissionsService(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }
    public Page<Permission> getAllPermissions(PagedDataRequest pagedDataRequest) {
        Page<Permission> permissions = this.permissionsRepository.findAll(pagedDataRequest.toPageable());
        return permissions;
    }
    public ByteArrayInputStream generateReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<Permission> permissionList = this.permissionsRepository.findAll();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Permissions");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
//        row.createCell(2).setCellValue("Description");
        int rowId = 1;
        for (Permission permission : permissionList) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(permission.getName());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }
}
