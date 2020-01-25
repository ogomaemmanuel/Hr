package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveType;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypesService {
    private final LeaveTypesRepository leaveTypesRepository;

    @Autowired
    public LeaveTypesService(LeaveTypesRepository leaveTypesRepository1) {
        this.leaveTypesRepository = leaveTypesRepository1;
    }

    public List<LeaveType> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = this.leaveTypesRepository.findAll();
        return leaveTypes;
    }

    public Page<LeaveType> getAllLeaveTypes(Pageable pageable) {
        Page<LeaveType> leaveTypes = this.leaveTypesRepository.findAll(pageable);
        return leaveTypes;
    }

    public Optional<LeaveType> getLeaveTypeById(Long id) {
        Optional<LeaveType> leaveType = this.leaveTypesRepository.findById(id);
        return leaveType;
    }

    public LeaveType createLeaveType(LeaveType leaveType) {
        this.leaveTypesRepository.save(leaveType);
        return leaveType;
    }


    public void updateLeaveType(Long id, LeaveType leaveType) {
        LeaveType dbLeaveType = this.leaveTypesRepository.findById(id).orElse(null);
        if (dbLeaveType != null) {
            dbLeaveType.setName(leaveType.getName());
            dbLeaveType.setNumberOfDays(leaveType.getNumberOfDays());
            leaveTypesRepository.save(dbLeaveType);
        }
    }
}
