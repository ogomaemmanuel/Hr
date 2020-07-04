package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities;

import com.ogoma.vue_starter.vue_starter.entities.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="overtime_requests")
public class OvertimeRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date overtimeDate;
    private Long overtimeHours;
    private String description;
    @Column(name = "employee_id")
    private Long employeeId;
    @ManyToOne
    @JoinColumn(name = "employee_id",insertable = false,updatable = false)
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOvertimeDate() {
        return overtimeDate;
    }

    public void setOvertimeDate(Date overtimeDate) {
        this.overtimeDate = overtimeDate;
    }

    public Long getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(Long overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
