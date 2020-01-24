package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveType;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services.LeaveTypesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(value = "api/leave-types", method = RequestMethod.POST)
    public ResponseEntity<?> createLeaveType(@RequestBody LeaveType leaveType) {
        leaveType = this.leaveTypesService.createLeaveType(leaveType);
        return ResponseEntity.ok(leaveType);
    }
}
