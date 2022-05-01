package com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo <T> extends JpaRepository<T,Long> , JpaSpecificationExecutor<T> {
}
