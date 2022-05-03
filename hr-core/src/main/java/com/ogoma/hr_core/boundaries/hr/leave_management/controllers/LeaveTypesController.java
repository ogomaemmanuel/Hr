package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveType;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services.LeaveTypesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Controller
public class LeaveTypesController {
    private final LeaveTypesService leaveTypesService;

    public LeaveTypesController(LeaveTypesService leaveTypesService) {
        this.leaveTypesService = leaveTypesService;
    }

    @RequestMapping(value = "api/leave-types", method = RequestMethod.GET)
    public ResponseEntity<?> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypesService.getAllLeaveTypes();
        return ResponseEntity.ok(leaveTypes);
    }

    @RequestMapping(value = "api/leave-types/paged", method = RequestMethod.GET)
    public ResponseEntity<?> getAllLeaveTypesPaged(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<LeaveType> leaveTypes = leaveTypesService.getAllLeaveTypes(pageable);
        return ResponseEntity.ok(leaveTypes);
    }

    @RequestMapping(value = "api/leave-types/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveById(@PathVariable Long id) {
        Optional<LeaveType> leaveType = this.leaveTypesService.getLeaveTypeById(id);
        return ResponseEntity.of(leaveType);
    }

    @RequestMapping(value = "api/leave-types", method = RequestMethod.POST)
    public ResponseEntity<?> createLeaveType(@Valid @RequestBody LeaveType leaveType) {
        leaveType = this.leaveTypesService.createLeaveType(leaveType);
        return ResponseEntity.ok(leaveType);
    }

    @RequestMapping(value = "api/leave-types/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLeaveType(@PathVariable Long id,@Valid @RequestBody LeaveType leaveType) {
        this.leaveTypesService.updateLeaveType(id, leaveType);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "api/leave-types/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeLeaveType(@PathVariable Long id) {
        this.leaveTypesService.removeLeaveTypeById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "api/leave-types/excel-report", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> holidaysExcelReport() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = this.leaveTypesService.generateExcelReport();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=leave-types-report.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
