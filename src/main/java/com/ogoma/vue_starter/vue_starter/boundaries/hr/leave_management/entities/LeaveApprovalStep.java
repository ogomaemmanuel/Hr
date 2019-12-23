package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import javax.persistence.*;

public class LeaveApprovalStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private LeaveApprovalStepsEnum leaveApprovalStepsEnum;

    public Long getId() {
        return id;
    }

    public LeaveApprovalStep setId(Long id) {
        this.id = id;
        return this;
    }

    public LeaveApprovalStepsEnum getLeaveApprovalStepsEnum() {
        return leaveApprovalStepsEnum;
    }

    public LeaveApprovalStep setLeaveApprovalStepsEnum(LeaveApprovalStepsEnum leaveApprovalStepsEnum) {
        this.leaveApprovalStepsEnum = leaveApprovalStepsEnum;
        return this;
    }
}
