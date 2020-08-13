package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.services.PayrollDeductionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PayrollDeductionController {
    private final PayrollDeductionService payrollDeductionService;

    public PayrollDeductionController(PayrollDeductionService payrollDeductionService) {
        this.payrollDeductionService = payrollDeductionService;
    }
    @RequestMapping(value = "api/payroll-deductions",method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody PayrollDeduction payrollDeduction) {
        payrollDeduction =
                this.payrollDeductionService.createPayrollDeduction(payrollDeduction);
        return ResponseEntity.ok(payrollDeduction);
    }
}
