package com.ogoma.hr_core.boundaries.company.services;

import com.ogoma.hr_core.boundaries.company.entities.CompanyDetail;
import com.ogoma.hr_core.boundaries.company.models.CompanyDetailModel;
import com.ogoma.hr_core.boundaries.company.repositories.CompanyDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailService {
    private final CompanyDetailRepository detailRepository;

    public CompanyDetailService(CompanyDetailRepository detailRepository){
        this.detailRepository = detailRepository;
    }

    public CompanyDetail getCompanyDetails(){
        return detailRepository.findAll().stream().findFirst().orElse(new CompanyDetail());
    }

    public String updateCompanyDetails(CompanyDetailModel model){
        CompanyDetail details = new CompanyDetail();
        if(null != model.getId())
            details = detailRepository.findById(model.getId()).orElse(new CompanyDetail());

        details.setName(model.getName());
        details.setWebsiteUrl(model.getWebsiteUrl());
        details.setRegistrationNo(model.getRegistrationNo());
        details.setDateEstablished(model.getDateEstablished());
        details.setBusinessDescription(model.getBusinessDescription());
        details.setBusinessEntityType(model.getBusinessEntityType());
        details.setStateOfIncorporation(model.getStateOfIncorporation());
        details.setEmail(model.getEmail());
        details.setLogoUrl(model.getLogoUrl());

        detailRepository.save(details);

        return "00";
    }
}
