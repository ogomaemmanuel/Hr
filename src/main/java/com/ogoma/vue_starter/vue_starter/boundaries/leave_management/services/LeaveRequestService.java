package com.ogoma.vue_starter.vue_starter.boundaries.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr_employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.boundaries.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.leave_management.repositories.LeaveRequestRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
    private LeaveRequestRepository leaveRequestRepository;
    @Autowired
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        leaveRequestRepository = leaveRequestRepository;
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
        Page<LeaveRequest> leaveRequests = leaveRequestRepository.findCurrentUserLeaveRequest(pageRequest);
        return leaveRequests;
    }
}
