package com.ogoma.hr_core.boundaries.attendance.repository;

import com.ogoma.hr_core.boundaries.attendance.entities.Attendance;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepo<Attendance> {
  public   List<Attendance> findAttendanceByEmployeeId(Long id);

  public List<Attendance> findAttendanceByAttendanceTimeBetween(LocalDateTime start, LocalDateTime endDateTime);
}
