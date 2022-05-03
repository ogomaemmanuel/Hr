package com.ogoma.hr_core.boundaries.company.services;

import com.ogoma.hr_core.boundaries.company.entities.NotificationSetting;
import com.ogoma.hr_core.boundaries.company.models.NotificationSettingModel;
import com.ogoma.hr_core.boundaries.company.repositories.NotificationSettingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationSettingService {
    private final NotificationSettingRepository settingRepository;

    public NotificationSettingService(NotificationSettingRepository settingRepository){
        this.settingRepository = settingRepository;
    }

    public List<NotificationSetting> getSettings(){
        return settingRepository.findAll();
    }

    public String updateSetting(NotificationSettingModel model){
        if(null == model.getId())
            return "01";

        NotificationSetting setting = settingRepository.findById(model.getId()).orElse(new NotificationSetting());

        setting.setNotify(model.getNotify());
        setting.setUpdatedAt(new Date());
        settingRepository.save(setting);

        return "00";
    }
}
