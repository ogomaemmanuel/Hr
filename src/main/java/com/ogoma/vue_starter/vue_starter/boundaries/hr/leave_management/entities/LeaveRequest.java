package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Staff;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.entities.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(name = "in_place")
    private Long inPlaceId;
    private Integer numberOfDays;
    @Column(name = "applicant_user_id")
    private Long applicantId;
    @Column(name = "leave_type_id")
    private Long leaveTypeId;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @OneToOne
    @JoinColumn(name = "applicant_user_id", updatable = false, insertable = false)
    private User applicant;
    @OneToOne
    @JoinColumn(name = "in_place", insertable = false, updatable = false)
    private Staff inPlace;
    @OneToOne
    @JoinColumn(name = "leave_type_id", insertable = false, updatable = false)
    private LeaveType leaveType;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LeaveRequest setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LeaveRequest setEndDate(LocalDate endDate) {
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

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public LeaveRequest setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
        return this;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public LeaveRequest setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LeaveRequest setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public LeaveRequest setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @PrePersist
    public void calculateEndDate() {
        this.endDate = this.startDate.plusDays(this.numberOfDays);

    }
}
