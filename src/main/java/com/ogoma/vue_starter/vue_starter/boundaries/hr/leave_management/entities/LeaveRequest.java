package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Staff;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.entities.User;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "in_place")
    private Long inPlaceId;
    private Integer numberOfDays;
    @Column(name = "applicant_user_id")
    private Long applicantId;
    @OneToOne
    @JoinColumn(name = "applicant_user_id", updatable = false, insertable = false)
    private User applicant;
    @OneToOne
    @JoinColumn(name = "in_place", insertable = false, updatable = false)
    private Staff inPlace;
    @Enumerated(value = EnumType.STRING)
    private LeaveStatuses leaveStatuses;

    public Long getId() {
        return id;
    }

    public LeaveRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LeaveRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public LeaveRequest setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public LeaveRequest setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public User getApplicant() {
        return applicant;
    }

    public LeaveRequest setApplicant(User applicant) {
        this.applicant = applicant;
        return this;
    }

    public LeaveStatuses getLeaveStatuses() {
        return leaveStatuses;
    }

    public LeaveRequest setLeaveStatuses(LeaveStatuses leaveStatuses) {
        this.leaveStatuses = leaveStatuses;
        return this;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public LeaveRequest setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
        return this;
    }

    public Staff getInPlace() {
        return inPlace;
    }

    public LeaveRequest setInPlace(Staff inPlace) {
        this.inPlace = inPlace;
        return this;
    }

    public Long getInPlaceId() {
        return inPlaceId;
    }

    public LeaveRequest setInPlaceId(Long inPlaceId) {
        this.inPlaceId = inPlaceId;
        return this;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveRequest setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    @PrePersist
    public void calculateEndDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);
        c.add(Calendar.DAY_OF_MONTH, this.numberOfDays);
        endDate = c.getTime();
    }
}
