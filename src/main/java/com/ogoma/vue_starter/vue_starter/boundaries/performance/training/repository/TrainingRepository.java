package com.ogoma.vue_starter.vue_starter.boundaries.performance.training.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long>, JpaSpecificationExecutor<Training> {

}
