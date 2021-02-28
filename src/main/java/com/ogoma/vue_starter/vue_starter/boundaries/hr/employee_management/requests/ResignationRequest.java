package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ResignationRequest {
    @NotNull(message = "Notice date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date noticeDate;
    @NotNull(message = "Resignation date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date resignationDate;
    @NotBlank(message = "Resignation reason is required")
    private String reason;
    @NotNull(message = "Select an employee")
    private Long employeeId;

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
}
