package com.ogoma.vue_starter.vue_starter.boundaries.jobs.services;

import com.ogoma.vue_starter.vue_starter.boundaries.asset_management.entities.Asset_;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job_;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.repositories.JobsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.jobs.requests.JobRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
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
        Page<Job> jobs = this.jobsRepository.findAll(
                ((root, query, criteriaBuilder) -> {
                    if (Long.class != query.getResultType()) {
                        root.fetch(Job_.department, JoinType.LEFT);
                    }
                    return criteriaBuilder.conjunction();
                }),
                pagedDataRequest.toPageable());
        return jobs;
    }

    public Job createJob(JobRequest jobRequest) {

        Department department =
                departmentsRepository.getOne(jobRequest.getDepartmentId());
        Job job = new Job();
        job.setAge(jobRequest.getAge());
        job.setDepartment(department);
        job.setTitle(jobRequest.getTitle());
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

        Optional<Job> job =
                this.jobsRepository.findById(id);
        Department department =
                departmentsRepository.getOne(jobRequest.getDepartmentId());
        job.ifPresent(j -> {
            j.setAge(jobRequest.getAge());
//        j.setDepartment(department);
            j.setTitle(jobRequest.getTitle());
            j.setDescription(jobRequest.getDescription());
            j.setExperience(jobRequest.getExperience());
            j.setLocation(jobRequest.getLocation());
            j.setEndDate(jobRequest.getEndDate());
            j.setStartDate(jobRequest.getStartDate());
            j.setMaximumSalary(jobRequest.getMaximumSalary());
            j.setMinimumSalary(jobRequest.getMinimumSalary());
            j.setType(jobRequest.getType());
            j.setVacancies(jobRequest.getVacancies());
            j.setStatus(jobRequest.getStatus());
            j.setDepartment(department);
            this.jobsRepository.save(j);
        });
        return job;
    }

    public void removeJob(Long id) {
        this.jobsRepository.deleteById(id);
    }
}
