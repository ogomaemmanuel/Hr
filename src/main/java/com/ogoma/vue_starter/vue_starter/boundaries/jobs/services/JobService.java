package com.ogoma.vue_starter.vue_starter.boundaries.jobs.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.repositories.JobsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests.JobRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    private final JobsRepository jobsRepository;
    private final DepartmentsRepository departmentsRepository;

    public JobService(JobsRepository jobsRepository,
                      DepartmentsRepository departmentsRepository) {
        this.jobsRepository = jobsRepository;
        this.departmentsRepository = departmentsRepository;
    }

    public Page<Job> getJobs(PagedDataRequest pagedDataRequest) {
        Page<Job> jobs = this.jobsRepository.findAll(pagedDataRequest.toPageable());
        return jobs;
    }

    public Job createJob(JobRequest jobRequest) {

        Department department =
                departmentsRepository.getOne(jobRequest.getDepartmentId());
        Job job = new Job();
        job.setAge(jobRequest.getAge());
        job.setDepartment(department);
        job.setDescription(jobRequest.getDescription());
        job.setExperience(jobRequest.getExperience());
        job.setLocation(jobRequest.getLocation());
        job.setEndDate(jobRequest.getEndDate());
        job.setMaximumSalary(jobRequest.getMaximumSalary());
        job.setMinimumSalary(jobRequest.getMinimumSalary());
        job.setType(jobRequest.getType());
        job.setVacancies(jobRequest.getVacancies());
        job.setStatus(Job.Status.Open);
        this.jobsRepository.save(job);
        return job;
    }

    public Optional<Job> getJobById(Long id) {
        Optional<Job> job = this.jobsRepository.findById(id);
        return job;
    }

    public Optional<Job> updateJob(Long id, JobRequest jobRequest) {
        //TODO implement method
        throw new RuntimeException("Method not implemented");
    }

    public void removeJob(Long id) {
        this.jobsRepository.deleteById(id);
    }
}
