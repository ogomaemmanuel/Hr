package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employee_resignations")
public class EmployeeResignation {
    @Id
    private Long id;
    @NotNull(message = "Notice date is required")
    @Temporal(TemporalType.DATE)
    private Date noticeDate;
    @NotNull(message = "Resignation date is required")
    @Temporal(TemporalType.DATE)
    private Date resignationDate;
    @NotBlank(message = "Resignation is required")
    private String reason;
    @OneToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Employee employee;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
       // employee.setEmployeeResignation(this);
        this.employee = employee;

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
