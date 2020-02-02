package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services.LeaveRequestService;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.validators.LeaveRequestModelValidator;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.ErrorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LeaveRequestsController {
    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestModelValidator leaveRequestModelValidator;

    @Autowired
    public LeaveRequestsController(LeaveRequestService leaveRequestService,
                                   LeaveRequestModelValidator leaveRequestModelValidator) {
        this.leaveRequestService = leaveRequestService;
        this.leaveRequestModelValidator = leaveRequestModelValidator;
    }

    @RequestMapping(value = "api/leave-request", method = RequestMethod.POST)
    public ResponseEntity<?> makeNewRequest(@RequestBody LeaveRequestModel leaveRequestModel, BindingResult bindingResult) {
        leaveRequestModelValidator.validate(leaveRequestModel, bindingResult);
        if (!bindingResult.hasErrors()) {
            LeaveRequest leaveRequest = leaveRequestService.createLeaveRequest(leaveRequestModel);
            return ResponseEntity.ok(leaveRequest);
        }
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(bindingResult);
        return ResponseEntity.badRequest().body(errors);
    }

    @RequestMapping(value = "api/leave-request/{requestId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLeaveRequest(@PathVariable("requestId") Long requestId, @RequestBody LeaveRequestModel leaveRequestModel, BindingResult bindingResult) {
        leaveRequestModelValidator.validate(leaveRequestModel, bindingResult);
        if (bindingResult.hasErrors()) {
            LeaveRequest leaveRequest = leaveRequestService.updateLeaveRequest(requestId, leaveRequestModel);
            return ResponseEntity.ok(leaveRequest);
        }
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(bindingResult);
        return ResponseEntity.badRequest().body(errors);
    }

    @RequestMapping(value = "api/user/leave-requests", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequests(PagedDataRequest pagedDataRequest) {
        Page<LeaveRequest> leaveRequests = leaveRequestService.getLoggedInUserLeaveRequest(pagedDataRequest);
        return ResponseEntity.ok(leaveRequests);
    }

    @RequestMapping(value = "api/user/leave-requests/{requestId}", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequestsById(@PathVariable Long requestId) {
        Optional<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestById(requestId);
        return ResponseEntity.of(leaveRequests);
    }

    @RequestMapping(value = "api/user/leave-requests/summary/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequestDetails(@PathVariable Long id) {
        Map<String, String> leaveRequests = leaveRequestService.getLeaveDetails(id);
        return ResponseEntity.ok(leaveRequests);
    }

    @RequestMapping(value = "api/leave-requests/in-place", method = RequestMethod.GET)
    public ResponseEntity<?> getInPlaceStaffsSelectLis() {
        List<Map<String, String>> inPlaceStaffSelectList = leaveRequestService.inPlaceStaffSelectList();
        return ResponseEntity.ok(inPlaceStaffSelectList);
    }

    @RequestMapping(value = "api/user/leave-balances", method = RequestMethod.GET)
    public ResponseEntity<?> getUserLeaveBalancles() {
        List<Map<String, String>> leaveBalances = leaveRequestService.getLoggedInUserLeaveBalances();
        return ResponseEntity.ok(leaveBalances);
    }

    @RequestMapping(value = "api/user/leave-balances/{leaveTypeId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserLeaveBalancesByLeaveTypeId(@PathVariable Long leaveTypeId ) {
        Long leaveBalance = leaveRequestService.getLoggedInUserLeaveBalanceByLeaveTypeId(leaveTypeId);
        return ResponseEntity.ok(leaveBalance);
    }

    @RequestMapping(value = "api/user/leave-requests/withdrawal/{leaveId}", method = RequestMethod.PUT)
    public ResponseEntity<?> withdrawLeave(@PathVariable("leaveId") Long leaveId) {
        ResponseModel responseModel = leaveRequestService.withdrawRequest(leaveId);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "api/leave-request-approvals", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequestToApprove(PagedDataRequest pagedDataRequest) {
        Page<Map<String, String>> leaveRequests = leaveRequestService.getLeaveRequestToApprove(pagedDataRequest);
        return ResponseEntity.ok(leaveRequests);
    }

    @RequestMapping(value = "api/leave-request-approvals/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> approveLeaveRequest(@PathVariable("id") Long leaveId) {
        ResponseModel responseModel = leaveRequestService.approveLeaveByLeaveId(leaveId);
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "api/leave-request-history/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequestHistoryByLeaveId(@PathVariable("id") Long id) {
        List<LeaveRequestHistory> leaveRequestHistories = this.leaveRequestService.getLeaveRequestHistoryByLeaveId(id);
        return ResponseEntity.ok(leaveRequestHistories);
    }


}
