package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
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

    @RequestMapping(value = "api/user/leave-balances", method = RequestMethod.GET)
    public ResponseEntity<?> getUserLeaveBalancles() {
        List<Map<String, String>> leaveBalances = leaveRequestService.getLoggedInUserLeaveBalances();
        return ResponseEntity.ok(leaveBalances);
    }
    @RequestMapping(value = "api/user/leave-requests/withdrawal/{leaveId}",method = RequestMethod.PUT)
    public ResponseEntity<?> withdrawLeave(@PathVariable("leaveId") Long leaveId){
      ResponseModel responseModel =  leaveRequestService.withdrawRequest(leaveId);
      return ResponseEntity.ok(responseModel);
    }
    @RequestMapping(value = "api/leave-request-approvals",method = RequestMethod.GET)
    public ResponseEntity<?> getLeaveRequestToApprove(PagedDataRequest pagedDataRequest){
        Page<LeaveRequest> leaveRequests =  leaveRequestService.getLeaveRequestToApprove(pagedDataRequest);
      return ResponseEntity.ok(leaveRequests);
    }

}
