package com.ogoma.hr_job_portal.boundaries.jobs.controllers;

import com.ogoma.hr_job_portal.boundaries.jobs.entities.Job;
import com.ogoma.hr_job_portal.boundaries.jobs.repositories.JobRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class JobsController {
    private final JobRepository jobRepository;

    public JobsController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @MutationMapping
    public Job createJob(@Argument("title") String title) {
        Job job = new Job();
        job.setTitle(title);
        jobRepository.save(job);
        return job;
    }

    @QueryMapping
    public List<Job> jobs() {
        return this.jobRepository.findAll();
    }
}
