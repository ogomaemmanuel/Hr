package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
//@Entity
public class LeaveRequestState {
    @OneToOne
    @MapsId
    LeaveRequest leaveRequest;
    @Id
    private Long id;
    private Long currentStep;
    private Long totalSteps;

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public LeaveRequestState setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LeaveRequestState setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCurrentStep() {
        return currentStep;
    }

    public LeaveRequestState setCurrentStep(Long currentStep) {
        this.currentStep = currentStep;
        return this;
    }

    public Long getTotalSteps() {
        return totalSteps;
    }

    public LeaveRequestState setTotalSteps(Long totalSteps) {
        this.totalSteps = totalSteps;
        return this;
    }
}
