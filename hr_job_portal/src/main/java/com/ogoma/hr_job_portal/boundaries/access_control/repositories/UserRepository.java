package com.ogoma.hr_job_portal.boundaries.access_control.repositories;

import com.ogoma.hr_job_portal.boundaries.access_control.entities.User;
import com.ogoma.hr_job_portal.common.BaseRepo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UserRepository extends BaseRepo<User> {
}
