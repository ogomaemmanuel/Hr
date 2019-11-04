package com.ogoma.vue_starter.vue_starter.boundaries.hr_employee_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr_employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.entities.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leave_requests")
public class LeaveRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToOne
    @JoinColumn(name = "applicant_user_id")
    private User applicant;
    @Enumerated(value = EnumType.STRING)
    private LeaveStatuses leaveStatuses;

    public Long getId() {
        return id;
    }

    public LeaveRequests setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LeaveRequests setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public LeaveRequests setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public LeaveRequests setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public User getApplicant() {
        return applicant;
    }

    public LeaveRequests setApplicant(User applicant) {
        this.applicant = applicant;
        return this;
    }

    public LeaveStatuses getLeaveStatuses() {
        return leaveStatuses;
    }

    public LeaveRequests setLeaveStatuses(LeaveStatuses leaveStatuses) {
        this.leaveStatuses = leaveStatuses;
        return this;
    }
}
