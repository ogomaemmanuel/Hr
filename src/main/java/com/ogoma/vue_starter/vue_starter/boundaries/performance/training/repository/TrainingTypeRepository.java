package com.ogoma.vue_starter.vue_starter.boundaries.performance.training.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.training.entities.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTypeRepository extends JpaRepository<TrainingType,Long> , JpaSpecificationExecutor<TrainingType> {

}
