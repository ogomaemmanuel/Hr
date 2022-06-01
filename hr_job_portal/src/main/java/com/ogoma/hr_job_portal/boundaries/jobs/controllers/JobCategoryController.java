package com.ogoma.hr_job_portal.boundaries.jobs.controllers;

import com.ogoma.hr_job_portal.boundaries.jobs.dtos.JobCategoryInput;
import com.ogoma.hr_job_portal.boundaries.jobs.entities.JobCategory;
import com.ogoma.hr_job_portal.boundaries.jobs.repositories.JobCategoryRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class JobCategoryController {
    private final JobCategoryRepository jobCategoryRepository;

    public JobCategoryController(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @MutationMapping
    public JobCategory addJobCategory(@Argument JobCategoryInput input){
        JobCategory jobCategory = new JobCategory();
        jobCategory.setName(input.getName());
      return   this.jobCategoryRepository.save(jobCategory);
    }
}
