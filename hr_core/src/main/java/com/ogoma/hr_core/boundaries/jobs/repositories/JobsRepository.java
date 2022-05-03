package com.ogoma.hr_core.boundaries.jobs.repositories;

import com.ogoma.hr_core.boundaries.jobs.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Job,Long> , JpaSpecificationExecutor<Job> {
}
