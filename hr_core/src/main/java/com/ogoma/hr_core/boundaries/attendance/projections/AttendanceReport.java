package com.ogoma.hr_core.boundaries.attendance.projections;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface AttendanceReport {
    public String getFullName();
    public Long getEmployeeId();
    public LocalDateTime getCheckInTime();
}
