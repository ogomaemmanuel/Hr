package com.ogoma.vue_starter.vue_starter.boundaries.attendance.services;

import com.ogoma.vue_starter.vue_starter.boundaries.attendance.entities.Attendance;
import com.ogoma.vue_starter.vue_starter.boundaries.attendance.repository.AttendanceRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.attendance.requests.AttendanceRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

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

        });
        return attendance;
    }


    public Attendance createAttendance(AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        convertToEntity(attendance, attendanceRequest);
        return attendance;
    }

    private void convertToEntity(Attendance attendance, AttendanceRequest attendanceRequest) {
        Employee employee = this.employeeRepository.getOne(attendanceRequest.getEmployeeId());
        attendance.setAttendanceTime(attendanceRequest.getAttendanceTime());
        attendance.setEmployee(employee);
        attendance.setType(attendanceRequest.getType());
    }


}
