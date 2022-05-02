package com.ogoma.vue_starter.vue_starter.boundaries.company.services;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.EmailSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.NotificationSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.EmailSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.NotificationSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.repositories.EmailSettingRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.company.repositories.NotificationSettingRepository;
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
