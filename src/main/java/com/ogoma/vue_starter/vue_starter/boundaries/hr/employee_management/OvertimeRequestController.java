package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.OvertimeRequestView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.OvertimeRequestService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
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
import java.io.IOException;
import java.util.Optional;

@Controller
public class OvertimeRequestController {
    private final OvertimeRequestService overtimeRequestService;

    public OvertimeRequestController(OvertimeRequestService overtimeRequestService) {
        this.overtimeRequestService = overtimeRequestService;
    }

    @RequestMapping(value = "api/overtime-requests", method = RequestMethod.GET)
    public ResponseEntity<?> getOvertimeRequests(PagedDataRequest pagedDataRequest) {
        Page<OvertimeRequestView> overtimeRequestViewPage =
                this.overtimeRequestService.getOvertimeRequests(pagedDataRequest);
        return ResponseEntity.ok(overtimeRequestViewPage);
    }

    @RequestMapping(value = "api/overtime-requests", method = RequestMethod.POST)
    public ResponseEntity<?> saveOvertimeRequest(@RequestBody @Valid OvertimeRequest overtimeRequest) {
        overtimeRequest = this.overtimeRequestService.createOvertimeRequest(overtimeRequest);
        return ResponseEntity.ok(overtimeRequest);
    }

    @RequestMapping(value = "api/overtime-requests/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOvertimeRequestById(@PathVariable("id") Long id) {
        Optional<OvertimeRequest> overtimeRequest =
                this.overtimeRequestService.getOvertimeById(id);
        return ResponseEntity.of(overtimeRequest);
    }

    @RequestMapping(value = "api/overtime-requests/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOvertimeRequest(@PathVariable("id") Long id,
                                                   @Valid @RequestBody OvertimeRequest overtimeRequest) {
        Optional<OvertimeRequest> overtimeRequest1 =
                this.overtimeRequestService.updateOvertimeRequest(id, overtimeRequest);
        return ResponseEntity.of(overtimeRequest1);
    }

    @RequestMapping(value = "api/overtime-requests/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeOvertimeRequest(@PathVariable Long id) {
        this.overtimeRequestService.removeOvertimeRequest(id);
        return ResponseEntity.ok("Overtime request successfully removed");
    }

    @RequestMapping(value = "api/overtime-requests/excel-reports",method = RequestMethod.GET)
    public ResponseEntity<?> getDepartmentsReport() throws IOException {
        ByteArrayInputStream byteArrayInputStream=  this.overtimeRequestService.generateReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=departments-report.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
