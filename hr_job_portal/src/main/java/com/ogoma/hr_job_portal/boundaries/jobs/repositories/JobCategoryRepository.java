package com.ogoma.hr_job_portal.boundaries.jobs.repositories;

import com.ogoma.hr_job_portal.boundaries.jobs.entities.JobCategory;
import com.ogoma.hr_job_portal.common.BaseRepo;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface JobCategoryRepository extends BaseRepo<JobCategory> {


}
