package com.ogoma.vue_starter.vue_starter.boundaries.company.controller;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.CompanyDetail;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.CompanyDetailModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.services.CompanyDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CompanyDetailController {
    private final CompanyDetailService detailService;

    public CompanyDetailController(CompanyDetailService detailService){
        this.detailService = detailService;
    }

    @GetMapping("api/company-details")
    public ResponseEntity<?> getCompanyDetails(){
        CompanyDetail details = detailService.getCompanyDetails();
        return ResponseEntity.ok(details);
    }

    @PostMapping("api/company-details/update")
    public ResponseEntity<?> updateCompanyDetails(@RequestBody @Valid CompanyDetailModel model){
        Map<String, String> resp = new HashMap<>();
        String status = detailService.updateCompanyDetails(model);
        if("00".equalsIgnoreCase(status)){
            resp.put("msg", "Details updated successfully");
            resp.put("status", "00");
        }else if("01".equalsIgnoreCase(status)){
            resp.put("msg", "Could not update company details");
            resp.put("status", "01");
        }
        return ResponseEntity.ok(resp);
    }
}
