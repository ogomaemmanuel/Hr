package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveType;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories.LeaveTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypesService {
    private final LeaveTypesRepository leaveTypesRepository;
    @Autowired
    public LeaveTypesService( LeaveTypesRepository leaveTypesRepository1) {
        this.leaveTypesRepository = leaveTypesRepository1;
    }
    public List<LeaveType> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = this.leaveTypesRepository.findAll();
        return leaveTypes;
    }


}
