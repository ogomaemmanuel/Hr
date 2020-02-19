package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events.LeaveRequestEvent;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events.LeaveRequestEventData;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models.LeaveRequestModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveHistoryRepository;
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
import java.util.Optional;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveHistoryRepository leaveHistoryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository,
                               LeaveHistoryRepository leaveHistoryRepository,
                               ApplicationEventPublisher applicationEventPublisher,
                               HttpServletRequest httpServletRequest) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveHistoryRepository = leaveHistoryRepository;
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

    public Optional<LeaveRequest> getLeaveRequestById(Long requestId) {
        Optional<LeaveRequest> leaveRequest = this.leaveRequestRepository.findById(requestId);
        return leaveRequest;
    }

    public Map<String, String> getLeaveDetails(Long id) {
        Map<String, String> leaveDetails =
                this.leaveRequestRepository.findLeaveRequestDetailsByLeaveId(id);
        return leaveDetails;
    }

    public List<LeaveRequestHistory> getLeaveRequestHistoryByLeaveId(Long leaveId) {
        List<LeaveRequestHistory> leaveRequestHistories = this.leaveHistoryRepository.findAllByLeaveRequest_Id(leaveId);
        return leaveRequestHistories;
    }

    public ResponseModel approveLeaveByLeaveId(Long leaveId) {
        ResponseModel responseModel = new ResponseModel();
        LeaveRequest leaveRequest = this.leaveRequestRepository.findById(leaveId).orElse(null);
        if (leaveRequest == null) {
            return responseModel.setMessage("Leave record not found");
        }
        if (leaveRequest.getLeaveStatuses().equals(LeaveStatuses.NEW.name())) {
            responseModel = processInPlaceApproval(leaveRequest);
            return responseModel;
        }
        if (leaveRequest.getLeaveStatuses().equals(LeaveStatuses.IN_PLACE_ACCEPTED.name())) {
            responseModel = processSupervisorApproval(leaveRequest);
            return responseModel;
        }

        return responseModel;
    }

    private ResponseModel processInPlaceApproval(LeaveRequest leaveRequest) {
        ResponseModel responseModel = new ResponseModel();
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        if (userId.compareTo(leaveRequest.getInPlace().getUser().getId()) == 0) {
            LeaveRequestHistory leaveRequestHistory = new LeaveRequestHistory();
            leaveRequestHistory.setPerformedBy(userId);
            leaveRequestHistory.setLeaveStatuses(LeaveStatuses.IN_PLACE_ACCEPTED.name());
            leaveRequest.setLeaveStatuses(LeaveStatuses.IN_PLACE_ACCEPTED.name());
            leaveRequest.addLeaveHistory(leaveRequestHistory);
            this.leaveRequestRepository.save(leaveRequest);
            responseModel
                    .setMessage("Leave request approval successful")
                    .setStatus("success");
            return responseModel;
        }
        responseModel
                .setStatus("fail")
                .setMessage("Leave not approved by in place employee");
        return responseModel;
    }

    private ResponseModel processSupervisorApproval(LeaveRequest leaveRequest) {
        ResponseModel responseModel = new ResponseModel();
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        if (userId.compareTo(leaveRequest.getInPlace().getUser().getId()) == 0) {
            LeaveRequestHistory leaveRequestHistory = new LeaveRequestHistory();
            leaveRequestHistory.setPerformedBy(userId);
            leaveRequestHistory.setLeaveStatuses(LeaveStatuses.APPROVED.name());
            leaveRequest.setLeaveStatuses(LeaveStatuses.APPROVED.name());
            leaveRequest.addLeaveHistory(leaveRequestHistory);
            this.leaveRequestRepository.save(leaveRequest);
            responseModel
                    .setMessage("Leave request approval successful")
                    .setStatus("success");
            return responseModel;
        }
        responseModel
                .setStatus("fail")
                .setMessage("Leave not approved by in place employee");
        return responseModel;
    }

    public LeaveRequest updateLeaveRequest(Long requestId, LeaveRequestModel leaveRequestModel) {
        LeaveRequest leaveRequest = this.leaveRequestRepository.findById(requestId).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setStartDate(leaveRequestModel.getStartDate());
            leaveRequest.setDescription(leaveRequestModel.getReason());
            leaveRequest.setNumberOfDays(leaveRequestModel.getNumberOfDays());
            leaveRequest.setEndDate(leaveRequestModel.getEndDate());
            leaveRequest.setInPlaceId(leaveRequestModel.getInPlaceId());
            this.leaveRequestRepository.save(leaveRequest);
        }
        return leaveRequest;
    }

    public Long getLoggedInUserLeaveBalanceByLeaveTypeId(Long leaveTypeId) {
        Long leaveBalance = this.leaveRequestRepository.currentUserLeaveBalanceByLeaveTypeId(leaveTypeId);
        if (leaveBalance == null) {
            leaveBalance = 0L;
        }
        return leaveBalance;
    }
}
