package com.ogoma.hr_job_portal.boundaries.jobs.repositories;

import com.ogoma.hr_job_portal.boundaries.jobs.entities.Job;
import com.ogoma.hr_job_portal.common.BaseRepo;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

@GraphQlRepository
public interface JobRepository extends BaseRepo<Job> {
}
