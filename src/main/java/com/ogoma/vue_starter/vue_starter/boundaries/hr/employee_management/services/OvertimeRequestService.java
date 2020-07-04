package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.OvertimeRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class OvertimeRequestService {
    private final OvertimeRequestRepository overtimeRequestRepository;

    public OvertimeRequestService(OvertimeRequestRepository overtimeRequestRepository) {
        this.overtimeRequestRepository = overtimeRequestRepository;
    }

    public OvertimeRequest createOvertimeRequest(OvertimeRequest overtimeRequest) {
        overtimeRequest = this.overtimeRequestRepository.save(overtimeRequest);
        return overtimeRequest;
    }
}
