package com.ogoma.hr_core.boundaries.attendance.repository;

import com.ogoma.hr_core.boundaries.attendance.entities.Attendance;
import com.ogoma.hr_core.boundaries.attendance.projections.PunchInPunchOutProjection;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface AttendanceRepository extends BaseRepo<Attendance> {
    public List<Attendance> findAttendanceByEmployeeId(Long id);

    public List<Attendance> findTop5AttendanceByAttendanceTimeBetween(LocalDateTime start, LocalDateTime endDateTime);

    @Query(nativeQuery = true, value = "select id,  attendance_time as punchInTime,(select attendance_time as punch_out_time  from attendance where type='PUNCH_OUT' and date(attendance_time)= date(now()) order by id desc limit 1) as punchOutTime, employee_id from attendance where type='PUNCH_IN' and date(attendance_time)= date(now()) order by id desc limit 1")
    public Map<String,String > getLastPunchInPunchOut();
}
