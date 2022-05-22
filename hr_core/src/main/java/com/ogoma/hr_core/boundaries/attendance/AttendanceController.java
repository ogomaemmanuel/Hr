package com.ogoma.hr_core.boundaries.attendance;

import com.ogoma.hr_core.boundaries.attendance.entities.Attendance;
import com.ogoma.hr_core.boundaries.attendance.requests.AttendanceRequest;
import com.ogoma.hr_core.boundaries.attendance.services.AttendanceService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<?> getAttendances() {
        List<Attendance> attendanceList = this.attendanceService.getAttendances();
        return ResponseEntity.ok(attendanceList);
    }

    @GetMapping(value = "employee/{employeeId}")
    public ResponseEntity<?> getEmployeeAttendances(@PathVariable Long employeeId) {
        List<Attendance> attendances =
                this.attendanceService.getAttendanceByEmployeeId(employeeId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAttendanceById(@PathVariable Long id) {
        Optional<Attendance> attendance = this.attendanceService.getAttendanceById(id);
        return ResponseEntity.of(attendance);
    }

    @GetMapping(value = "/today-activity")
    public ResponseEntity<?> getAttendanceActivityToday() {
        List<Attendance> attendancePage = this.attendanceService.todayAttendanceActivities();
        return ResponseEntity.ok(attendancePage);
    }

    @PostMapping
    public ResponseEntity<?> createAttendance(@RequestBody @Valid AttendanceRequest attendanceRequest) {
        Attendance attendance = this.attendanceService.createAttendance(attendanceRequest);
        return ResponseEntity.ok(attendance);
    }

    @PostMapping(value = "/me")
    public ResponseEntity<?> createAttendanceForCurrentUser(@RequestBody @Valid AttendanceRequest attendanceRequest) {
        Attendance attendance = this.attendanceService.createAttendanceForCurrentUser(attendanceRequest);
        return ResponseEntity.ok(attendance);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAttendance(@PathVariable Long id, @RequestBody @Valid AttendanceRequest attendanceRequest) {
        Optional<Attendance> attendance =
                this.attendanceService.updateAttendance(id, attendanceRequest);
        return ResponseEntity.of(attendance);
    }


}
