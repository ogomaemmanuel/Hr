package com.ogoma.hr_core.boundaries.performance.appraisals.services;

import com.ogoma.hr_core.boundaries.performance.appraisals.repositories.AppraisalCycleRepository;
import org.springframework.stereotype.Service;

@Service
public class AppraisalCycleService {
    private final AppraisalCycleRepository appraisalCycleRepository;

    public AppraisalCycleService(AppraisalCycleRepository appraisalCycleRepository) {
        this.appraisalCycleRepository = appraisalCycleRepository;
    }


}
