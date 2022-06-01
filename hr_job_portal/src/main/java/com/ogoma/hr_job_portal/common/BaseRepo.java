package com.ogoma.hr_job_portal.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T,Long> , JpaSpecificationExecutor<T>, QuerydslPredicateExecutor<T> {
}
