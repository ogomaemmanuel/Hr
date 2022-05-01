package com.ogoma.vue_starter.vue_starter.boundaries.attendance.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.attendance.entities.Attendance;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepo<Attendance> {
  public   List<Attendance> findAttendanceByEmployeeId(Long id);
}
