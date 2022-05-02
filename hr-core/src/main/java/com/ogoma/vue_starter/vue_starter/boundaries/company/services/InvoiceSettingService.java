package com.ogoma.vue_starter.vue_starter.boundaries.company.services;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.EmailSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.InvoiceSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.NotificationSetting;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.InvoiceSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.models.NotificationSettingModel;
import com.ogoma.vue_starter.vue_starter.boundaries.company.repositories.InvoiceSettingRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.company.repositories.NotificationSettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceSettingService {
    private final InvoiceSettingRepository settingRepository;

    public InvoiceSettingService(InvoiceSettingRepository settingRepository){
        this.settingRepository = settingRepository;
    }

    public InvoiceSetting getSetting(){
        //TODO get image from path
        return settingRepository.findAll().stream().findFirst().orElse(new InvoiceSetting());
    }

    public String updateSetting(InvoiceSettingModel model){
        InvoiceSetting setting = new InvoiceSetting();
        if(null != model.getId())
            setting = settingRepository.findById(model.getId()).orElse(new InvoiceSetting());

        String logoPath = imageUpload(model);

        setting.setPrefix(model.getPrefix());
        setting.setLogoUrl(logoPath);
        setting.setUpdatedAt(new Date());
        settingRepository.save(setting);

        return "00";
    }


    public String imageUpload(InvoiceSettingModel model){
        //TODO get a path for this image
        String fileDirectory = "/Users/hr/";

        MultipartFile file = model.getLogoUrl();
        String id = String.valueOf(model.getId());
        Path filePath = Paths.get(fileDirectory, id + "-" + file.getOriginalFilename());
        String fileUrl = fileDirectory + id + "-" + file.getOriginalFilename();
        try {
            Files.write(filePath, file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }
}
