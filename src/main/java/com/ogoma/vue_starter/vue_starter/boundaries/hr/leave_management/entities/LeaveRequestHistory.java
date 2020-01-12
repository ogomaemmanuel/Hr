package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.entities.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leave_requests_history")
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = "LeaveRequestHistory.performed_by",
        attributeNodes = @NamedAttributeNode("user"))
public class LeaveRequestHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leaveStatuses;
    @Column(name = "performed_by")
    private Long performedBy;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performed_by", insertable = false, updatable = false)
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_request_id")
    @JsonIgnoreProperties("leaveRequestHistory")
    private LeaveRequest leaveRequest;

    public Long getId() {
        return id;
    }

    public LeaveRequestHistory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLeaveStatuses() {
        return leaveStatuses;
    }

    public LeaveRequestHistory setLeaveStatuses(String leaveStatuses) {
        this.leaveStatuses = leaveStatuses;
        return this;
    }

    public Long getPerformedBy() {
        return performedBy;
    }

    public LeaveRequestHistory setPerformedBy(Long performedBy) {
        this.performedBy = performedBy;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LeaveRequestHistory setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public LeaveRequestHistory setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public LeaveRequestHistory setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public LeaveRequestHistory setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
        return this;
    }

}
