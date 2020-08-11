package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.services.PayrollAdditionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PayrollAdditionController {
    private final PayrollAdditionsService payrollAdditionsService;
    public PayrollAdditionController(PayrollAdditionsService payrollAdditionsService) {
        this.payrollAdditionsService = payrollAdditionsService;
    }
    @RequestMapping(value = "api/payroll-additions",method = RequestMethod.POST)
    public ResponseEntity<?> savePayrollAddition(@Valid @RequestBody PayrollAddition payrollAddition) {
        payrollAddition =
                this.payrollAdditionsService.createPayrollAddition(payrollAddition);
        return ResponseEntity.ok(payrollAddition);
    }
}
