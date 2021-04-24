package com.ogoma.vue_starter.vue_starter.boundaries.jobs;

import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests.JobRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.services.JobService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class JobsController {
    private final JobService jobService;

    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }
    @RequestMapping(value = "api/jobs",method = RequestMethod.GET)
    public ResponseEntity<?> getAllJobs(PagedDataRequest pagedDataRequest) {
        Page<Job> jobs=
                this.jobService.getJobs(pagedDataRequest);
        return ResponseEntity.ok(jobs);
    }
    @RequestMapping("api/jobs")
    public ResponseEntity<?> createJob(@RequestBody @Valid JobRequest jobRequest){
     Job job= this.jobService.createJob(jobRequest);
     return ResponseEntity.ok(job);
    }
}
