package com.ogoma.hr_core.boundaries.attendance.projections;

public interface AttendanceSummary {
    public Double getAttendanceToday();
    public Double getWeekAttendance();
    public Double getMonthAttendance();
    public Double getYearAttendance();
}
