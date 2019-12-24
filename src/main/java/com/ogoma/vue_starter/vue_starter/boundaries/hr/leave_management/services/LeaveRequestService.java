package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveRequestRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public LeaveRequest createLeaveRequest(LeaveRequestModel leaveRequestModel) {
        LeaveRequest leaveRequest = new LeaveRequest();
        BeanUtils.copyProperties(leaveRequestModel, leaveRequest);
        leaveRequest.setLeaveStatuses(LeaveStatuses.NEW);
        leaveRequest.setApplicantId(SecurityUtils.getCurrentUserDetails().getId());
        leaveRequestRepository.save(leaveRequest);
        return leaveRequest;
    }

    public Page<LeaveRequest> getLoggedInUserLeaveRequest(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<LeaveRequest> leaveRequests =
                leaveRequestRepository.findCurrentUserLeaveRequest(pageRequest);
        return leaveRequests;
    }

    public List<Map<String, String>> inPlaceStaffSelectList() {
        List<Map<String, String>> inPlaceEmployeeSelectList =
                this.leaveRequestRepository.getInplaceEmployeeSelectList();
        return inPlaceEmployeeSelectList;
    }

    public List<Map<String, String>> getLoggedInUserLeaveBalances() {
        List<Map<String, String>> leaveBalances =
                this.leaveRequestRepository.findCurrentUserLeaveBalances();
        return leaveBalances;
    }
}
