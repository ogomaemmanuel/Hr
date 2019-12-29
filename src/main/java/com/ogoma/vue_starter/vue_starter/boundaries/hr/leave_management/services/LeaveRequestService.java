package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events.LeaveRequestEvent;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events.LeaveRequestEventData;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveRequestRepository;
import com.ogoma.vue_starter.vue_starter.models.ResponseModel;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.BaseUrlUtil;
import com.ogoma.vue_starter.vue_starter.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository, ApplicationEventPublisher applicationEventPublisher, HttpServletRequest httpServletRequest) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.httpServletRequest = httpServletRequest;
    }

    public LeaveRequest createLeaveRequest(LeaveRequestModel leaveRequestModel) {
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        LeaveRequestHistory leaveRequestHistory = new
                LeaveRequestHistory();
        leaveRequestHistory.setPerformedBy(userId);
        leaveRequestHistory.setLeaveStatuses(LeaveStatuses.NEW.name());
        LeaveRequest leaveRequest = new LeaveRequest();
        BeanUtils.copyProperties(leaveRequestModel, leaveRequest);
        leaveRequest.setLeaveStatuses(LeaveStatuses.NEW.name());
        leaveRequest.setApplicantId(userId);
        leaveRequest.addLeaveHistory(leaveRequestHistory);
        leaveRequestRepository.save(leaveRequest);
        LeaveRequestEventData leaveRequestEventData = new LeaveRequestEventData(
                leaveRequestHistory,
                BaseUrlUtil.getBaseUrlBuilder(this.httpServletRequest));
        applicationEventPublisher.publishEvent(new LeaveRequestEvent(this, leaveRequestEventData));
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

    public Long getLoggedInUserLeaveBalance(Long leaveTypeId) {
        Long leaveBalance = this.leaveRequestRepository.currentUserLeaveBalanceByLeaveTypeId(leaveTypeId);
        return leaveBalance;
    }

    public ResponseModel withdrawRequest(Long leaveId) {
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        LeaveRequest leaveRequest = this.leaveRequestRepository.findById(leaveId).orElse(null);
        leaveRequest.setLeaveStatuses(LeaveStatuses.WITHDRAWN.name());
        LeaveRequestHistory leaveRequestHistory = new
                LeaveRequestHistory();
        leaveRequestHistory.setPerformedBy(userId);
        leaveRequestHistory.setLeaveStatuses(LeaveStatuses.WITHDRAWN.name());
        leaveRequest.addLeaveHistory(leaveRequestHistory);
        this.leaveRequestRepository.save(leaveRequest);
        LeaveRequestEventData leaveRequestEventData = new LeaveRequestEventData(
                leaveRequestHistory,
                BaseUrlUtil.getBaseUrlBuilder(this.httpServletRequest));
        applicationEventPublisher.publishEvent(new LeaveRequestEvent(this, leaveRequestEventData));
        ResponseModel responseModel = new ResponseModel()
                .setStatus("success")
                .setData(leaveRequest)
                .setMessage("leave successfully withdrawn");
        return responseModel;
    }

    public Page<Map<String, String>> getLeaveRequestToApprove(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        List<String> leaveStatuses = new ArrayList<>();
        leaveStatuses.add(LeaveStatuses.NEW.name());
        Page<Map<String, String>> leaveRequests = this.leaveRequestRepository.getLeaveRequestToApprove(leaveStatuses, pageable);
        return leaveRequests;
    }

    public Map<String, String> getLeaveDetails(Long id) {
        Map<String, String> leaveDetails =
                this.leaveRequestRepository.findLeaveRequestDetailsByLeaveId(id);
        return leaveDetails;
    }
}
