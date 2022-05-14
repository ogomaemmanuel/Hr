package com.ogoma.hr_core.boundaries.company.services;

import com.ogoma.hr_core.boundaries.company.entities.EmailSetting;
import com.ogoma.hr_core.boundaries.company.models.EmailSettingModel;
import com.ogoma.hr_core.boundaries.company.repositories.EmailSettingRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingService {
    private final EmailSettingRepository settingRepository;

    public EmailSettingService(EmailSettingRepository settingRepository){
        this.settingRepository = settingRepository;
    }

    public EmailSetting getSetting(){
        return settingRepository.findAll().stream().findFirst().orElse(new EmailSetting());
    }

    public String updateSetting(EmailSettingModel model){
        EmailSetting setting = new EmailSetting();
        if(null != model.getId())
            setting = settingRepository.findById(model.getId()).orElse(new EmailSetting());

        setting.setName(model.getName());
        setting.setAddress(model.getAddress());
        setting.setAddress(model.getAddress());
        setting.setSmtpHost(model.getSmtpHost());
        setting.setSmtpPort(model.getSmtpPort());
        setting.setSmtpUser(model.getSmtpUser());
        setting.setSmtpPassword(model.getSmtpPassword());
        setting.setSmtpSecurity(model.getSmtpSecurity());
        setting.setDomainAuthentication(model.getDomainAuthentication());

        settingRepository.save(setting);

        return "00";
    }
}
