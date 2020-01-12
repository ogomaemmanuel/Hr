package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LeaveRequestModel {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    private Integer numberOfDays;
    private String reason;
    private Long inPlaceId;
    private Long leaveTypeId;
    public LocalDate getStartDate() {
        return startDate;
    }

    public LeaveRequestModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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
}
