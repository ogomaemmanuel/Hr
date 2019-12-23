package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services.LeaveRequestService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class LeaveRequestsController {
    private final LeaveRequestService leaveRequestService;
    @Autowired
    public LeaveRequestsController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }
    @RequestMapping(value = "api/leave-request", method = RequestMethod.POST)
    public ResponseEntity<?> makeNewRequest(@RequestBody LeaveRequestModel leaveRequestModel) {
        LeaveRequest leaveRequest = leaveRequestService.createLeaveRequest(leaveRequestModel);
        return ResponseEntity.ok(leaveRequest);
    }
    @RequestMapping(value = "api/user/leave-requests", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRquests(PagedDataRequest pagedDataRequest) {
        Page<LeaveRequest> leaveRequests = leaveRequestService.getLoggedInUserLeaveRequest(pagedDataRequest);
        return ResponseEntity.ok(leaveRequests);
    }
    @RequestMapping(value = "api/leave-requests/in-place", method = RequestMethod.GET)
    public ResponseEntity<?> getInPlaceStaffsSelectLis() {
        List<Map<String, String>> inPlaceStaffSelectList = leaveRequestService.inPlaceStaffSelectList();
        return ResponseEntity.ok(inPlaceStaffSelectList);
    }
}
