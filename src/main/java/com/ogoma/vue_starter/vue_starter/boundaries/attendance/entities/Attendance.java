package com.ogoma.vue_starter.vue_starter.boundaries.attendance.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "attendance")
public class Attendance {
    public enum Type{
        PUNCH_IN,
        PUNCH_OUT
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee employee;
    private Date attendanceTime;
    private Type type;
    private  Date createdAt;
    private  Date updatedAT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(Date updatedAT) {
        this.updatedAT = updatedAT;
    }
}
