package com.ogoma.hr_core.boundaries.attendance.projections;

import java.time.LocalDateTime;

public interface PunchInPunchOutProjection {
    public LocalDateTime getPunchInTime();
    public LocalDateTime getPunchOutTime();
}
