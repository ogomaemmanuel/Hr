package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Staff;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leave_requests")
@EntityListeners(AuditingEntityListener.class)
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("reason")
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "in_place")
    private Long inPlaceId;
    private Integer numberOfDays;
    @Column(name = "applicant_user_id")
    private Long applicantId;
    @Column(name = "leave_type_id")
    private Long leaveTypeId;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_user_id", updatable = false, insertable = false)
    private User applicant;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "in_place", insertable = false, updatable = false)
    private Staff inPlace;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type_id", insertable = false, updatable = false)
    private LeaveType leaveType;
    @OneToMany(mappedBy = "leaveRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("leaveRequest")
    private Set<LeaveRequestHistory> leaveRequestHistory = new HashSet<>();

    private String leaveStatuses;

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

    public String getLeaveStatuses() {
        return leaveStatuses;
    }

    public LeaveRequest setLeaveStatuses(String leaveStatuses) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public LeaveRequest setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public LeaveRequest setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Set<LeaveRequestHistory> getLeaveRequestHistory() {
        return leaveRequestHistory;
    }

    public LeaveRequest setLeaveRequestHistory(Set<LeaveRequestHistory> leaveRequestHistory) {
        this.leaveRequestHistory = leaveRequestHistory;
        return this;
    }

    public void addLeaveHistory(LeaveRequestHistory leaveRequestHistory) {
        if (leaveRequestHistory != null) {
            leaveRequestHistory.setLeaveRequest(this);
            this.leaveRequestHistory.add(leaveRequestHistory);
        }

    }
}
