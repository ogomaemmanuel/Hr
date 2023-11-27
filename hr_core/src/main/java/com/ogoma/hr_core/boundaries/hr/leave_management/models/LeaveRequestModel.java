package com.ogoma.hr_core.boundaries.hr.leave_management.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class LeaveRequestModel {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private Integer numberOfDays;
    private String reason;
    private Long inPlaceId;
    private Long leaveTypeId;
    
    private List<Long> approversIds;

    public Date getStartDate() {
        return startDate;
    }

    public LeaveRequestModel setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }
    public Date getEndDate() {
        return endDate;
    }
    public LeaveRequestModel setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveRequestModel setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public LeaveRequestModel setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Long getInPlaceId() {
        return inPlaceId;
    }

    public LeaveRequestModel setInPlaceId(Long inPlaceId) {
        this.inPlaceId = inPlaceId;
        return this;
    }

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public LeaveRequestModel setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
        return this;
    }

    public List<Long> getApproversIds() {
        return approversIds;
    }

    public void setApproversIds(List<Long> approversIds) {
        this.approversIds = approversIds;
    }
}
