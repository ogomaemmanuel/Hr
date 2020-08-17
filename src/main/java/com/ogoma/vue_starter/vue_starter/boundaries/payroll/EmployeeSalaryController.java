package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeSalaryController {
    @RequestMapping(value = "/api/payslip/me", method = RequestMethod.GET)
    public String getPayslip()  {

        return "payroll/payslip";
    }


}
