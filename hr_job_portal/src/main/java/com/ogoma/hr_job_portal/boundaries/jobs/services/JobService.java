package com.ogoma.hr_job_portal.boundaries.jobs.services;

import com.ogoma.hr_job_portal.boundaries.QueryBuilder;
import com.ogoma.hr_job_portal.boundaries.jobs.dtos.JobInput;
import com.ogoma.hr_job_portal.boundaries.jobs.entities.Job;
import com.ogoma.hr_job_portal.boundaries.jobs.entities.QJob;
import com.ogoma.hr_job_portal.boundaries.jobs.entities.QJobCategory;
import com.ogoma.hr_job_portal.boundaries.jobs.repositories.JobRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import graphql.schema.SelectedField;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobService {
    private final JobRepository jobRepository;
    private final EntityManager entityManager;

    public JobService(JobRepository jobRepository, EntityManager entityManager) {
        this.jobRepository = jobRepository;
        this.entityManager = entityManager;
    }

//    private List<Job> getJobs(DataFetchingEnvironment dataFetchingEnvironment) {
//        DataFetchingFieldSelectionSet selectionSet =
//                dataFetchingEnvironment.getSelectionSet();
//
//    }

    public Job createJob(JobInput input) {
        Job job = new Job();
        job.setTitle(input.getTitle());
        job.setVacancies(input.getVacancies());
        job.setDescription(input.getDescription());
        job.setDeadline(input.getDeadline());
        this.jobRepository.save(job);
        return job;
    }

}
