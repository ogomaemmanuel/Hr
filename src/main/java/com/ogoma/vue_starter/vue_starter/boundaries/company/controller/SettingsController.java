package com.ogoma.vue_starter.vue_starter.boundaries.company.controller;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.CompanyDetail;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.EmailSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.InvoiceSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.NotificationSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.CompanyDetailModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.EmailSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.InvoiceSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.NotificationSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.services.CompanyDetailService;
import com.ogoma.vue_starter.vue_starter.boundaries.company.services.EmailSettingService;
import com.ogoma.vue_starter.vue_starter.boundaries.company.services.InvoiceSettingService;
import com.ogoma.vue_starter.vue_starter.boundaries.company.services.NotificationSettingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SettingsController {
    private final CompanyDetailService detailService;
    private final EmailSettingService emailSettingService;
    private final NotificationSettingService notificationSettingService;
    private final InvoiceSettingService invoiceSettingService;

    public SettingsController(InvoiceSettingService invoiceSettingService,CompanyDetailService detailService,EmailSettingService emailSettingService,NotificationSettingService notificationSettingService){
        this.detailService = detailService;
        this.emailSettingService = emailSettingService;
        this.notificationSettingService = notificationSettingService;
        this.invoiceSettingService = invoiceSettingService;
    }

    @GetMapping("api/settings/company")
    public ResponseEntity<?> getCompanyDetails(){
        CompanyDetail details = detailService.getCompanyDetails();
        return ResponseEntity.ok(details);
    }

    @PostMapping("api/settings/company/update")
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

    @GetMapping("api/settings/email")
    public ResponseEntity<?> getEmailSetting(){
        EmailSetting setting = emailSettingService.getSetting();
        return ResponseEntity.ok(setting);
    }

    @PostMapping("api/settings/email/update")
    public ResponseEntity<?> updateEmailSettings(@RequestBody @Valid EmailSettingModel model){
        Map<String, String> resp = new HashMap<>();
        String status = emailSettingService.updateSetting(model);
        if("00".equalsIgnoreCase(status)){
            resp.put("msg", "Setting updated successfully");
            resp.put("status", "00");
        }else if("01".equalsIgnoreCase(status)){
            resp.put("msg", "Could not update email settings");
            resp.put("status", "01");
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("api/settings/notifications")
    public ResponseEntity<?> getNotificationSetting(){
        List<NotificationSetting> settings = notificationSettingService.getSettings();
        return ResponseEntity.ok(settings);
    }

    @PostMapping("api/settings/notifications/update")
    public ResponseEntity<?> updateNotificationSettings(@RequestBody @Valid NotificationSettingModel model){
        Map<String, String> resp = new HashMap<>();
        String status = notificationSettingService.updateSetting(model);
        if("00".equalsIgnoreCase(status)){
            resp.put("msg", "Setting updated successfully");
            resp.put("status", "00");
        }else if("01".equalsIgnoreCase(status)){
            resp.put("msg", "Could not update notification settings");
            resp.put("status", "01");
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("api/settings/invoice")
    public ResponseEntity<?> getInvoiceSetting(){
        InvoiceSetting setting = invoiceSettingService.getSetting();
        return ResponseEntity.ok(setting);
    }

    @PostMapping("api/settings/invoice/update")
    public ResponseEntity<?> updateInvoiceSettings(@ModelAttribute @Valid InvoiceSettingModel model){
        Map<String, String> resp = new HashMap<>();
        String status = invoiceSettingService.updateSetting(model);
        if("00".equalsIgnoreCase(status)){
            resp.put("msg", "Setting updated successfully");
            resp.put("status", "00");
        }else if("01".equalsIgnoreCase(status)){
            resp.put("msg", "Could not update invoice settings");
            resp.put("status", "01");
        }
        return ResponseEntity.ok(resp);
    }
}
