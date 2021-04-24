package com.ogoma.vue_starter.vue_starter.boundaries.jobs.services;

import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.repositories.JobsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests.JobRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class JobService {
    private final JobsRepository jobsRepository;
    public JobService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public Page<Job> getJobs(PagedDataRequest pagedDataRequest) {
        Page<Job> jobs= this.jobsRepository.findAll(pagedDataRequest.toPageable());
        return jobs;
    }

    public Job createJob(JobRequest jobRequest) {
        //TODO implement method, should also send a message to the queue
        throw  new RuntimeException("method not implemented");
    }
}
