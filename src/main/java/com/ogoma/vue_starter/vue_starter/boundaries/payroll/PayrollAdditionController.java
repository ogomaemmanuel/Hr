package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.services.PayrollAdditionsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PayrollAdditionController {
    private final PayrollAdditionsService payrollAdditionsService;

    public PayrollAdditionController(PayrollAdditionsService payrollAdditionsService) {
        this.payrollAdditionsService = payrollAdditionsService;
    }

    @RequestMapping(value = "api/payroll-additions", method = RequestMethod.POST)
    public ResponseEntity<?> savePayrollAddition(@Valid @RequestBody PayrollAddition payrollAddition) {
        payrollAddition =
                this.payrollAdditionsService.createPayrollAddition(payrollAddition);
        return ResponseEntity.ok(payrollAddition);
    }

    @RequestMapping(value = "api/payroll-additions", method = RequestMethod.GET)
    public ResponseEntity<?> getPayrollAdditions(PagedDataRequest pagedDataRequest) {
        Page<PayrollAddition> payrollAdditions =
                this.payrollAdditionsService.getPayrollAdditions(pagedDataRequest);
        return ResponseEntity.ok(payrollAdditions);
    }

    @RequestMapping(value = "api/payroll-additions/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePayrollAddition(@PathVariable("id") Long id, @Valid @RequestBody PayrollAddition payrollAddition) {
        Optional<PayrollAddition> payrollAddition1 =
                this.payrollAdditionsService.upPayrollAddition(id, payrollAddition);
        return ResponseEntity.of(payrollAddition1);
    }

    @RequestMapping(value = "api/payroll-additions/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getPayrollAddition(@PathVariable("id") Long id) {
        Optional<PayrollAddition> payrollAddition =
                this.payrollAdditionsService.getPayrollAdditionById(id);
        return ResponseEntity.of(payrollAddition);
    }
}
