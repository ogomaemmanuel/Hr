package com.ogoma.vue_starter.vue_starter.boundaries.jobs;

import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests.JobRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.services.JobService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class JobsController {
    private final JobService jobService;

    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(value = "api/jobs", method = RequestMethod.GET)
    public ResponseEntity<?> getAllJobs(PagedDataRequest pagedDataRequest) {
        Page<Job> jobs =
                this.jobService.getJobs(pagedDataRequest);
        return ResponseEntity.ok(jobs);
    }

    @RequestMapping(value = "api/jobs/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getJobById(@PathVariable Long id) {
        Optional<Job> job = this.jobService.getJobById(id);
        return ResponseEntity.of(job);
    }

    @RequestMapping(value = "api/jobs", method = RequestMethod.POST)
    public ResponseEntity<?> createJob(@RequestBody @Valid JobRequest jobRequest) {
        Job job = this.jobService.createJob(jobRequest);
        return ResponseEntity.ok(job);
    }

    @RequestMapping(value = "api/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody @Valid JobRequest jobRequest) {
        Optional<Job> job =
                this.jobService.updateJob(id, jobRequest);
        return ResponseEntity.of(job);
    }

    @RequestMapping(value = "api/jobs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeJob(@PathVariable Long id) {
        this.jobService.removeJob(id);
        return ResponseEntity.ok("Job successfully removed");
    }



}
