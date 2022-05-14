package com.ogoma.hr_core.boundaries.performance.training.repository;

import com.ogoma.hr_core.boundaries.performance.training.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long>, JpaSpecificationExecutor<Training> {

}
