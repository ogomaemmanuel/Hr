package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Notice date is required")
    private Date noticeDate;
    @NotNull(message = "Resignation date is required")
    private Date resignationDate;
    @NotBlank(message = "Resignation is required")
    private String reason;
    @Column(name = "employee_id")
    @NotNull(message = "Select an Employee")
    private Long employeeId;
    @OneToOne
    @JoinColumn(insertable = false, updatable = false)
    private Employee employee;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Long getId() {
        return id;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
