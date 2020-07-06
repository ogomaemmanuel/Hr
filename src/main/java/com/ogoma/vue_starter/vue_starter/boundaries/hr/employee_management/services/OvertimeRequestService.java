package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.OvertimeRequestView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.OvertimeRequestRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OvertimeRequestService {
    private final OvertimeRequestRepository overtimeRequestRepository;

    public OvertimeRequestService(OvertimeRequestRepository overtimeRequestRepository) {
        this.overtimeRequestRepository = overtimeRequestRepository;
    }

    public Page<OvertimeRequestView> getOvertimeRequests(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<OvertimeRequestView> overtimeRequestViews = this.overtimeRequestRepository.getAll(pageRequest);
        return overtimeRequestViews;
    }

    public OvertimeRequest createOvertimeRequest(OvertimeRequest overtimeRequest) {
        overtimeRequest = this.overtimeRequestRepository.save(overtimeRequest);
        return overtimeRequest;
    }
}
