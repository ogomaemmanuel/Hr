package com.ogoma.vue_starter.vue_starter.boundaries.jobs.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.jobs.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Job,Long> , JpaSpecificationExecutor<Job> {
}
