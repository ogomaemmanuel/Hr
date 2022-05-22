package com.ogoma.hr_core.boundaries.attendance.services;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import com.ogoma.hr_core.boundaries.attendance.entities.Attendance;
import com.ogoma.hr_core.boundaries.attendance.repository.AttendanceRepository;
import com.ogoma.hr_core.boundaries.attendance.requests.AttendanceRequest;
import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.hr_core.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.hr_core.utils.CustomUserDetailsProvider;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Attendance> getAttendances() {
        List<Attendance> attendances = this.attendanceRepository.findAll();
        return attendances;
    }

    public void removeAttendance(Long id) {
        this.attendanceRepository.deleteById(id);
    }

    public List<Attendance> getAttendanceByEmployeeId(Long id) {
        List<Attendance> attendanceListt = this.attendanceRepository.findAttendanceByEmployeeId(id);
        return attendanceListt;
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        Optional<Attendance> attendance = this.attendanceRepository.findById(id);
        return attendance;
    }

    public Optional<Attendance> updateAttendance(Long id, AttendanceRequest attendanceRequest) {
        Optional<Attendance> attendance =
                this.attendanceRepository.findById(id);
        attendance.ifPresent(at -> {
            convertToEntity(at, attendanceRequest);
            this.attendanceRepository.save(at);
        });
        return attendance;
    }


    public Attendance createAttendance(AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        convertToEntity(attendance, attendanceRequest);
        this.attendanceRepository.save(attendance);
        return attendance;
    }

    private void convertToEntity(Attendance attendance, AttendanceRequest attendanceRequest) {
        Employee employee = this.employeeRepository.getOne(attendanceRequest.getEmployeeId());
        attendance.setAttendanceTime(attendanceRequest.getAttendanceTime());
        attendance.setEmployee(employee);
        attendance.setType(attendanceRequest.getType());
    }


    public Attendance createAttendanceForCurrentUser(AttendanceRequest attendanceRequest) {
        CustomUserDetailsProvider customUserDetailsProvider = new CustomUserDetailsProvider();
        CustomUserDetails userDetails = customUserDetailsProvider.getCurrentUserDetails();
        attendanceRequest.setEmployeeId(userDetails.getId());
        return this.createAttendance(attendanceRequest);
    }

    public List<Attendance> todayAttendanceActivities() {
      List<Attendance> attendances =
              this.attendanceRepository.findAttendanceByAttendanceTimeBetween((LocalDateTime.now().toLocalDate().atTime(LocalTime.MIN)),LocalDateTime.now());
      return  attendances;
    }
}

