package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.OvertimeRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.OvertimeRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class OvertimeRequestController {
    private final OvertimeRequestService overtimeRequestService;

    public OvertimeRequestController(OvertimeRequestService overtimeRequestService) {
        this.overtimeRequestService = overtimeRequestService;
    }

    @RequestMapping(value = "api/overtime-requests", method = RequestMethod.POST)
    public void saveOvertimeRequest(@RequestBody @Valid OvertimeRequest overtimeRequest) {

    }
}
