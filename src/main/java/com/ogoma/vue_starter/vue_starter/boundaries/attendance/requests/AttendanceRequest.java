package com.ogoma.vue_starter.vue_starter.boundaries.attendance.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.attendance.entities.Attendance;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class AttendanceRequest {
    private Long employeeId;
    private Date attendanceTime;
    @Enumerated(EnumType.STRING)
    private Attendance.Type type;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Attendance.Type getType() {
        return type;
    }

    public void setType(Attendance.Type type) {
        this.type = type;
    }

}
